package com.rmakiyama.skeleton.feature.home.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.rmakiyama.skeleton.feature.home.HomeScreen
import com.rmakiyama.skeleton.navigation.HomeRoute
import com.rmakiyama.skeleton.navigation.NavKey

fun EntryProviderScope<NavKey>.homeEntry() {
    entry<HomeRoute> {
        HomeScreen()
    }
}
