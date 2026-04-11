import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.rmakiyama.skeleton.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.sqldelight.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "skeleton.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
register("kotlinMultiplatform") {
            id = "skeleton.kotlin.multiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
        register("kotlinMultiplatformIos") {
            id = "skeleton.kotlin.multiplatform.ios"
            implementationClass = "KotlinMultiplatformIosConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "skeleton.compose.multiplatform"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
        register("metro") {
            id = "skeleton.metro"
            implementationClass = "MetroConventionPlugin"
        }
        register("iosFramework") {
            id = "skeleton.ios.framework"
            implementationClass = "IosFrameworkConventionPlugin"
        }
        register("feature") {
            id = "skeleton.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("sqldelight") {
            id = "skeleton.sqldelight"
            implementationClass = "SqlDelightConventionPlugin"
        }
    }
}
