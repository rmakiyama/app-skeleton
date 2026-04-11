plugins {
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
    id("skeleton.metro")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain)
            implementation(libs.metro.runtime)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}
