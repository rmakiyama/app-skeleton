plugins {
    id("skeleton.android.library")
    id("skeleton.kotlin.multiplatform")
    id("skeleton.kotlin.multiplatform.ios")
    id("skeleton.metro")
    id("skeleton.sqldelight")
}

sqldelight {
    databases {
        create("SkeletonDatabase") {
            packageName.set("com.rmakiyama.skeleton.data.db")
        }
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain)
            implementation(libs.metro.runtime)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
        }
    }
}
