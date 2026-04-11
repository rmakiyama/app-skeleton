package com.rmakiyama.skeleton

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun getDefaultNamespace(project: Project): String {
    val basePackage = "com.rmakiyama.skeleton"

    if (project.path == ":app-android") {
        return basePackage
    }

    val modulePath = project.path
        .removePrefix(":")
        .replace(":", ".")

    return "$basePackage.$modulePath"
}
