package com.rmakiyama.skeleton.repository.di

import com.rmakiyama.skeleton.datasource.di.DataSourceModule
import com.rmakiyama.skeleton.repository.DefaultItemRepository
import com.rmakiyama.skeleton.repository.ItemRepository

class RepositoryModule(
    private val dataSourceModule: DataSourceModule,
) {

    fun provideItemRepository(): ItemRepository {
        return DefaultItemRepository(
            dataSource = dataSourceModule.provideItemDataSource(),
        )
    }
}
