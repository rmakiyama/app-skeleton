package com.rmakiyama.skeleton.di

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.Provider
import dev.zacsweers.metrox.viewmodel.MetroViewModelFactory
import kotlin.reflect.KClass

@Inject
@ContributesBinding(AppScope::class)
class InjectedViewModelFactory(
    override val viewModelProviders: Map<KClass<out ViewModel>, Provider<ViewModel>>,
) : MetroViewModelFactory()
