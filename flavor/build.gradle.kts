import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
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

// Maven Central through the Central Portal. The plugin configures the release
// variant with sources and javadoc jars, the POM, GPG signing and the upload.
// Credentials and the signing key come from Gradle properties or the
// ORG_GRADLE_PROJECT_* environment variables set by the publish workflow.
mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            javadocJar = JavadocJar.Empty(),
            sourcesJar = SourcesJar.Sources(),
            variant = "release",
        ),
    )
    publishToMavenCentral()

    // Sign only when a key is configured, so publishToMavenLocal works on a
    // machine without one. The publish workflow always provides the key, and
    // the Central Portal rejects unsigned uploads if it is ever missing.
    val signingKeyConfigured = providers.gradleProperty("signingInMemoryKey").isPresent ||
        providers.gradleProperty("signing.keyId").isPresent
    if (signingKeyConfigured) {
        signAllPublications()
    }

    coordinates("com.hendramarihot", "flavor", libs.versions.flavor.get())

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
