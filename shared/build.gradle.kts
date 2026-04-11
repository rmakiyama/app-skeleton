plugins {
    id("skeleton.android.library")
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
    id("skeleton.ios.framework")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kermit)
        }
    }
}
