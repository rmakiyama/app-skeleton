package com.rmakiyama.skeleton.navigation

import kotlinx.serialization.Serializable

sealed interface NavKey

@Serializable
data object HomeRoute : NavKey
