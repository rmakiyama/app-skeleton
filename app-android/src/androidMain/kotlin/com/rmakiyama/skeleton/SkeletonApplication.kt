package com.rmakiyama.skeleton

import android.app.Application
import com.rmakiyama.skeleton.di.AppGraph
import dev.zacsweers.metro.createGraphFactory
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.android.MetroApplication

class SkeletonApplication : Application(), MetroApplication {
    override val appComponentProviders: MetroAppComponentProviders by lazy {
        createGraphFactory<AppGraph.Factory>().create(this)
    }
}
