import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import com.rmakiyama.skeleton.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.compose.ComposeExtension
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

                val compose = project.extensions.getByType<ComposeExtension>()

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
                        implementation(compose.dependencies.ui)
                        implementation(compose.dependencies.material3)
                        implementation(compose.dependencies.materialIconsExtended)
                        implementation(compose.dependencies.foundation)
                        implementation(compose.dependencies.components.resources)

                        implementation(libs.findLibrary("androidx-navigation3-runtime").get())

                        implementation(libs.findLibrary("metro-runtime-compose").get())
                    }
                }
            }
        }
    }
}
