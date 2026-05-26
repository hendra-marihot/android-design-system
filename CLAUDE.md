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

Coordinates: `com.hendramarihot:flavor:0.1.0`

The `maven-publish` plugin is applied in `flavor/build.gradle.kts`. The publication is
registered as `"release"` under groupId `com.hendramarihot`, artifactId `flavor`,
version `0.1.0`.

Full Maven Central publishing is configured: POM metadata, GPG signing (in-memory
PGP keys via env vars), and Sonatype OSSRH repository.

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
| AGP | 8.9.1 |
| Kotlin | 2.1.21 |
| Compose BOM | 2025.05.01 |
| Lifecycle | 2.9.1 |
| Navigation Compose | 2.9.0 |
| Kotlinx Serialization | 1.7.3 |

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

SDK targets: `compileSdk = 35`, `minSdk = 26`, JVM target 17.
