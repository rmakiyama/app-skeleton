plugins {
    id("skeleton.android.application")
    id("skeleton.kotlin.multiplatform")
    id("skeleton.compose.multiplatform")
    id("skeleton.metro")
    alias(libs.plugins.kotlinSerialization)
}

android {
    defaultConfig {
        applicationId = "com.rmakiyama.skeleton"
        versionCode = 1
        versionName = "1.0"
    }
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.navigation3.runtime)
            implementation(libs.androidx.navigation3.ui)
            implementation(libs.androidx.lifecycle.viewmodel.navigation3)
            implementation(libs.androidx.material3.adaptive.navigation3)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.metro.runtime)
            implementation(libs.metro.runtime.compose)
            implementation(libs.metro.android)
            implementation(projects.shared)
            implementation(projects.core.ui)
            implementation(projects.core.navigation)
            implementation(projects.feature.home)
            implementation(projects.domain)
            implementation(projects.data)
            implementation(projects.usecase)
        }
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
