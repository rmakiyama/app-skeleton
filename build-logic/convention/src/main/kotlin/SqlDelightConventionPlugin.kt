import com.rmakiyama.skeleton.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class SqlDelightConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("app.cash.sqldelight")

            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(libs.findLibrary("sqldelight-runtime").get())
                        implementation(libs.findLibrary("sqldelight-coroutines").get())
                    }
                    androidMain.dependencies {
                        implementation(libs.findLibrary("sqldelight-driver-android").get())
                    }
                    iosMain.dependencies {
                        implementation(libs.findLibrary("sqldelight-driver-native").get())
                    }
                }
            }
        }
    }
}
