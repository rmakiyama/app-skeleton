package com.rmakiyama.skeleton

import org.gradle.api.Project

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
