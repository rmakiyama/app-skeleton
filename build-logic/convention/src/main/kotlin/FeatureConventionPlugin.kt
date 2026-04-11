import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import com.rmakiyama.skeleton.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("skeleton.kotlin.multiplatform")
            pluginManager.apply("skeleton.kotlin.multiplatform.ios")
            pluginManager.apply("skeleton.compose.multiplatform")
            pluginManager.apply("skeleton.metro")
            pluginManager.apply("dev.mokkery")

            extensions.configure<KotlinMultiplatformExtension> {
                targets.withType<KotlinMultiplatformAndroidLibraryTarget>().configureEach {
                    androidResources { enable = true }
                }

                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(project(":core:ui"))
                        implementation(project(":core:navigation"))
                        implementation(project(":shared"))
                        implementation(project(":usecase"))
                        implementation(project(":domain"))

                        implementation(libs.findLibrary("metro-runtime").get())
                    }
                    androidMain.dependencies {
                        implementation(libs.findLibrary("compose-ui").get())
                        implementation(libs.findLibrary("compose-material3").get())
                        implementation(libs.findLibrary("compose-materialIconsExtended").get())
                        implementation(libs.findLibrary("compose-foundation").get())
                        implementation(libs.findLibrary("compose-components-resources").get())

                        implementation(libs.findLibrary("androidx-navigation3-runtime").get())

                        implementation(libs.findLibrary("metro-runtime-compose").get())
                    }
                }
            }
        }
    }
}
