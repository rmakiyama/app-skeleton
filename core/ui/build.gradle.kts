plugins {
    id("skeleton.android.library")
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
    id("skeleton.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.designsystem)
        }
        androidMain.dependencies {
            implementation(compose.ui)
            implementation(compose.material3)
        }
    }
}
