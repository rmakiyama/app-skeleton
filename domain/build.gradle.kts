plugins {
    id("skeleton.android.library")
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
        }
    }
}
