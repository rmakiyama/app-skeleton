import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import com.rmakiyama.skeleton.getDefaultNamespace
import com.rmakiyama.skeleton.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.kotlin.multiplatform.library")
            pluginManager.apply("org.jetbrains.kotlin.multiplatform")

            extensions.configure<KotlinMultiplatformExtension> {
                compilerOptions {
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }

                targets.withType<KotlinMultiplatformAndroidLibraryTarget>().configureEach {
                    namespace = getDefaultNamespace(project)
                    compileSdk = libs.findVersion("android-compileSdk").get().toString().toInt()
                    minSdk = libs.findVersion("android-minSdk").get().toString().toInt()

                    compilerOptions {
                        jvmTarget.set(JvmTarget.JVM_11)
                    }
                }

                sourceSets.apply {
                    commonTest.dependencies {
                        implementation(libs.findLibrary("kotlin-test").get())
                        implementation(libs.findLibrary("kotlinx-coroutines-test").get())
                        implementation(libs.findLibrary("turbine").get())
                        implementation(libs.findLibrary("kotest-assertions-core").get())
                    }
                }
            }
        }
    }
}
