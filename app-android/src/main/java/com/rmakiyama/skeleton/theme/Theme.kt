package com.rmakiyama.skeleton.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val skeletonLightColorScheme = lightColorScheme(
    primary = skeletonLightPrimary,
    onPrimary = skeletonLightOnPrimary,
    primaryContainer = skeletonLightPrimaryContainer,
    onPrimaryContainer = skeletonLightOnPrimaryContainer,
    inversePrimary = skeletonLightInversePrimary,
    secondary = skeletonLightSecondary,
    onSecondary = skeletonLightOnSecondary,
    secondaryContainer = skeletonLightSecondaryContainer,
    onSecondaryContainer = skeletonLightOnSecondaryContainer,
    tertiary = skeletonLightTertiary,
    onTertiary = skeletonLightOnTertiary,
    tertiaryContainer = skeletonLightTertiaryContainer,
    onTertiaryContainer = skeletonLightOnTertiaryContainer,
    error = skeletonLightError,
    onError = skeletonLightOnError,
    errorContainer = skeletonLightErrorContainer,
    onErrorContainer = skeletonLightOnErrorContainer,
    background = skeletonLightBackground,
    onBackground = skeletonLightOnBackground,
    surface = skeletonLightSurface,
    onSurface = skeletonLightOnSurface,
    inverseSurface = skeletonLightInverseSurface,
    inverseOnSurface = skeletonLightInverseOnSurface,
    surfaceVariant = skeletonLightSurfaceVariant,
    onSurfaceVariant = skeletonLightOnSurfaceVariant,
    outline = skeletonLightOutline
)

private val skeletonDarkColorScheme = darkColorScheme(
    primary = skeletonDarkPrimary,
    onPrimary = skeletonDarkOnPrimary,
    primaryContainer = skeletonDarkPrimaryContainer,
    onPrimaryContainer = skeletonDarkOnPrimaryContainer,
    inversePrimary = skeletonDarkInversePrimary,
    secondary = skeletonDarkSecondary,
    onSecondary = skeletonDarkOnSecondary,
    secondaryContainer = skeletonDarkSecondaryContainer,
    onSecondaryContainer = skeletonDarkOnSecondaryContainer,
    tertiary = skeletonDarkTertiary,
    onTertiary = skeletonDarkOnTertiary,
    tertiaryContainer = skeletonDarkTertiaryContainer,
    onTertiaryContainer = skeletonDarkOnTertiaryContainer,
    error = skeletonDarkError,
    onError = skeletonDarkOnError,
    errorContainer = skeletonDarkErrorContainer,
    onErrorContainer = skeletonDarkOnErrorContainer,
    background = skeletonDarkBackground,
    onBackground = skeletonDarkOnBackground,
    surface = skeletonDarkSurface,
    onSurface = skeletonDarkOnSurface,
    inverseSurface = skeletonDarkInverseSurface,
    inverseOnSurface = skeletonDarkInverseOnSurface,
    surfaceVariant = skeletonDarkSurfaceVariant,
    onSurfaceVariant = skeletonDarkOnSurfaceVariant,
    outline = skeletonDarkOutline
)

@Composable
fun SkeletonTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit,
) {
    val colors = if (!useDarkTheme) {
        skeletonLightColorScheme
    } else {
        skeletonDarkColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
