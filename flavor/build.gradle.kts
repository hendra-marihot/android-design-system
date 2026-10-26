plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
    signing
}

val javaVersion = JavaVersion.toVersion(libs.versions.java.get())

android {
    namespace = "com.hendramarihot.flavor"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    buildFeatures {
        compose = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

kotlin {
    // Pin the JDK that runs the compilers so builds match across machines and CI.
    jvmToolchain(javaVersion.majorVersion.toInt())
}

dependencies {
    val composeBom = platform(libs.compose.bom)
    api(composeBom)
    api(libs.compose.ui)
    api(libs.compose.material3)
    api(libs.compose.material.icons.extended)
    api(libs.compose.foundation)
    implementation(libs.compose.animation)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.test.manifest)
}

val libraryVersion = "0.1.0"

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.hendramarihot"
            artifactId = "flavor"
            version = libraryVersion
            afterEvaluate {
                from(components["release"])
            }
            pom {
                name.set("Flavor")
                description.set("Jetpack Compose design system library with Material 3 components and customizable design tokens")
                url.set("https://github.com/hendra-marihot/android-design-system")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("hendra-marihot")
                        name.set("Hendra Marihot")
                        email.set("hendra.marihot@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/hendra-marihot/android-design-system.git")
                    developerConnection.set("scm:git:ssh://github.com/hendra-marihot/android-design-system.git")
                    url.set("https://github.com/hendra-marihot/android-design-system")
                }
            }
        }
    }
    repositories {
        maven {
            name = "sonatype"
            val releasesUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (libraryVersion.endsWith("SNAPSHOT")) snapshotsUrl else releasesUrl
            credentials {
                username = findProperty("ossrhUsername") as String? ?: System.getenv("OSSRH_USERNAME") ?: ""
                password = findProperty("ossrhPassword") as String? ?: System.getenv("OSSRH_PASSWORD") ?: ""
            }
        }
    }
}

signing {
    val signingKeyId = findProperty("signing.keyId") as String? ?: System.getenv("SIGNING_KEY_ID")
    val signingKey = findProperty("signing.key") as String? ?: System.getenv("SIGNING_KEY")
    val signingPassword = findProperty("signing.password") as String? ?: System.getenv("SIGNING_PASSWORD")
    if (signingKeyId != null && signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
        sign(publishing.publications["release"])
    }
}

tasks.withType<Sign>().configureEach {
    isRequired = !libraryVersion.endsWith("SNAPSHOT")
}
