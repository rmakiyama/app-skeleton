# AGENTS.md

Kotlin Multiplatform mobile app.

## Build

```bash
./gradlew assembleDebug          # Android build
./gradlew testDebugUnitTest      # Run tests
```

- Java 21 (Temurin). Version managed via `mise.toml`
- CI enforces `warningsAsErrors=true` — compiler warnings are build failures

## Conventions

- Namespace is auto-derived from the module path (`NamespaceUtils.kt`). Never set it manually
- Test dependencies (kotlin-test, coroutines-test, turbine, kotest) are added automatically by Convention Plugins. Do not declare them in modules
- When adding new code, follow the patterns in existing modules of the same kind

## Adding a Feature Module

1. Create `feature/<name>/`. `build.gradle.kts` only needs `id("skeleton.feature")`
2. Add `include(":feature:<name>")` to `settings.gradle.kts`
3. Add a Route to `:core:navigation`
4. Expose a navigation entry extension function from the feature module
5. Register the entry in the NavGraph in `app-android`
