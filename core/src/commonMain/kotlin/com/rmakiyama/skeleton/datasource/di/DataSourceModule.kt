package com.rmakiyama.skeleton.datasource.di

import com.rmakiyama.skeleton.datasource.ItemDataSource
import com.rmakiyama.skeleton.datasource.ItemDummyDataSource

class DataSourceModule {

    fun provideItemDataSource(): ItemDataSource {
        return ItemDummyDataSource()
    }
}
