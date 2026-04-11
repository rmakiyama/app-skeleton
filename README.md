# App Skeleton

A template repository for mobile apps built with Kotlin Multiplatform.

## Architecture

Clean Architecture with a multi-module structure.

```mermaid
graph TD
    app-android --> shared
    app-android --> core:ui
    app-android --> core:navigation
    app-android --> feature:home
    app-android --> domain
    app-android --> data
    app-android --> usecase

    feature:home --> core:ui
    feature:home --> core:navigation
    feature:home --> shared
    feature:home --> usecase
    feature:home --> domain

    core:ui --> designsystem

    usecase --> domain
    data --> domain

    model

    style app-android fill:#4CAF50,color:#fff
    style domain fill:#FF9800,color:#fff
    style data fill:#2196F3,color:#fff
    style usecase fill:#9C27B0,color:#fff
    style feature:home fill:#E91E63,color:#fff
    style designsystem fill:#00BCD4,color:#fff
```

## Tech Stacks

- Android
    - Jetpack Compose
    - Material 3
    - Navigation3
    - Edge-to-Edge
    - Metro (compile-time DI)
- iOS
    - SwiftUI
    - Shared framework (static)
- Kotlin Multiplatform
    - Coroutines
    - SQLDelight
    - Kermit
- Testing
    - Mokkery
    - Turbine
    - Kotest
- Development
    - Convention Plugins (`build-logic/`)
    - Gradle Version Catalog

## Setup

1. Clone this repository
2. Open in Android Studio
3. Sync Gradle
4. Run `app-android` configuration
