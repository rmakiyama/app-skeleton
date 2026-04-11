package com.rmakiyama.skeleton.di

import android.content.Context
import com.rmakiyama.skeleton.data.SQLDelightItemRepository
import com.rmakiyama.skeleton.data.db.DatabaseDriverFactory
import com.rmakiyama.skeleton.data.db.SkeletonDatabase
import com.rmakiyama.skeleton.domain.ItemRepository
import com.rmakiyama.skeleton.usecase.GetItemsStream
import com.rmakiyama.skeleton.usecase.GetItemsStreamUseCase
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.SingleIn
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.viewmodel.ViewModelGraph

@DependencyGraph(AppScope::class)
interface AppGraph : ViewModelGraph, MetroAppComponentProviders {

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Provides context: Context): AppGraph
    }

    @Provides
    @SingleIn(AppScope::class)
    private fun provideDatabaseDriverFactory(
        context: Context,
    ): DatabaseDriverFactory = DatabaseDriverFactory(context)

    @Provides
    @SingleIn(AppScope::class)
    private fun provideSkeletonDatabase(
        driverFactory: DatabaseDriverFactory,
    ): SkeletonDatabase = SkeletonDatabase(driverFactory.createDriver())

    @Provides
    @SingleIn(AppScope::class)
    private fun provideItemRepository(
        impl: SQLDelightItemRepository,
    ): ItemRepository = impl

    @Provides
    private fun provideGetItemsStreamUseCase(
        impl: GetItemsStream,
    ): GetItemsStreamUseCase = impl
}
