plugins {
    id("skeleton.android.application")
    id("skeleton.metro")
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

android {
    defaultConfig {
        applicationId = "com.rmakiyama.skeleton"
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.components.resources)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.androidx.material3.adaptive.navigation3)
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

    debugImplementation(libs.compose.ui.tooling)
}
