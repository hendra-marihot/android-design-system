# Flavor — Android Design System

Compose UI component library with a companion catalog app. The library (`flavor`) is
publishable to Maven Central. The catalog (`catalog`) is a standalone demo APK that
is never distributed as a library.

## Module Structure

```
android-design-system/
├── flavor/          # Android library module — the publishable component library
└── catalog/         # Android application module — visual catalog / demo app
```

The `:flavor` module must not import anything from `:catalog`. `:catalog` depends
on `:flavor` via `implementation(project(":flavor"))`.

## Build Commands

Needs a JDK 17 or newer to run Gradle and the API 37 platform (`platforms;android-37.0`). If the local JDK is newer than 17, the toolchain resolver downloads JDK 17 for compilation. AGP installs the platform when the SDK licenses are accepted.

```bash
# Library
./gradlew :flavor:assembleRelease          # Build release AAR
./gradlew :flavor:publishToMavenLocal      # Publish to ~/.m2 for local testing

# Catalog app
./gradlew :catalog:assembleDebug           # Build debug APK

# Analysis
./gradlew lint                             # Run Android Lint across all modules
./gradlew test                             # Run unit tests across all modules
./gradlew connectedAndroidTest             # Run Compose UI tests (requires emulator)
```

## Maven Publishing

Coordinates: `com.hendramarihot:flavor:<version>`, with the version in `gradle/libs.versions.toml` as `flavor`.

`flavor/build.gradle.kts` applies `com.vanniktech.maven.publish`, which configures the
release variant with sources and javadoc jars, POM metadata, GPG signing and the Maven
Central Portal upload. Do not add `maven-publish` or `signing` by hand; the plugin owns them.

Releasing: bump `flavor` in the catalog, merge, then push a tag `v<version>`. The publish
workflow verifies the tag against the catalog and runs `publishAndReleaseToMavenCentral`.
Secrets: `MAVEN_CENTRAL_USERNAME`, `MAVEN_CENTRAL_PASSWORD` (portal user token),
`SIGNING_KEY` (ASCII-armored private key), `SIGNING_KEY_PASSWORD`.

Local check without credentials: `./gradlew :flavor:publishToMavenLocal`.

## Component API Conventions

Every composable in `:flavor` must follow these rules without exception:

1. **`modifier: Modifier = Modifier` is always the first optional parameter** after
   required parameters (following the standard Compose API guideline). Never omit it,
   even for components that do not currently apply it.

2. **Never hardcode colors.** All color references go through
   `MaterialTheme.colorScheme.*`. Design-token values (spacing, radius, elevation,
   icon sizes) live in `FlavorTokens` and are accessed either directly or via
   `Flavor.tokens` inside a composition.

3. **`FlavorTokens` is the single source of design tokens.** Do not introduce raw
   `Dp` literals for spacing, radius, elevation, or icon sizes — always reference the
   appropriate token via `Flavor.tokens.spacingMd` in composable context, or
   `FlavorTokens.Default.spacingMd` in default parameter values.

4. **Dark/light mode support is automatic** through Material 3's color system.
   Components require no manual theming; they inherit correctly from
   `MaterialTheme.colorScheme`.

5. **No Android framework imports in component code** except `@Preview`-related
   configuration constants. Files under `flavor/src/main/kotlin/` must not import
   `android.*` classes beyond `android.content.res.Configuration`. Pure Compose only.

6. **Wrap the app under `FlavorTheme`.** `FlavorTheme` provides
   `LocalFlavorTokens` and delegates theming to `MaterialTheme`. Always wrap the
   root composable in `FlavorTheme` before using any Flavor component.

## Dependency Management

All versions are declared in `gradle/libs.versions.toml` (Version Catalog). Do not
add version strings inline in `build.gradle.kts` files.

Key versions (as of last update):

| Dependency | Version |
|---|---|
| Gradle | 9.7.1 |
| AGP | 9.3.2 (built-in Kotlin, no `kotlin-android` plugin) |
| Kotlin | 2.4.21 |
| Compose BOM | 2026.09.00 |
| Lifecycle | 2.11.0 |
| Navigation Compose | 2.10.2 |
| Kotlinx Serialization | 1.12.0 |

## Architecture Notes

- **`FlavorTheme`** — wraps `MaterialTheme` and provides `LocalFlavorTokens` via
  `CompositionLocal`. Callers can read tokens with `Flavor.tokens` inside any
  composable.
- **`FlavorTokens`** — `@Immutable data class` with a `Default` companion. Passed
  into `FlavorTheme(tokens = ...)` to support per-tenant token overrides.
  Library components read via `Flavor.tokens` (CompositionLocal).
- **Navigation in `:catalog`** — type-safe `@Serializable` data object routes
  (Navigation 2.8+). Route classes defined in `CatalogApp.kt`.
- **Components** — the library has 10 component packages: `bottomsheet`, `button`,
  `card`, `dialog`, `input`, `loading` (Shimmer + Skeleton), `state` (EmptyView +
  ErrorView), `theme`. Each catalog screen mirrors one package.
- **CI** — GitHub Actions workflow (`.github/workflows/ci.yml`) runs build + test +
  lint on PRs and pushes to main.

## Adding Components

Each component lives in its own package under `com.hendramarihot.flavor.<name>/`.
One composable per file, named `Flavor<Name>.kt`. Matching test in
`src/androidTest/.../`. Matching catalog screen in `catalog/.../screens/`.

SDK targets: `compileSdk = 37`, `minSdk = 26`, `targetSdk = 36` (catalog app), JDK 17 toolchain.
They are read from `[versions]` in `gradle/libs.versions.toml`, so change them there.
