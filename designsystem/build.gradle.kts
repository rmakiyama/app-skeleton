plugins {
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
    id("skeleton.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
        }
        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.foundation)
        }
    }
}
