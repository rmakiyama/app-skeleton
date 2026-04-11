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
            implementation(compose.ui)
            implementation(compose.material3)
            implementation(compose.foundation)
        }
    }
}
