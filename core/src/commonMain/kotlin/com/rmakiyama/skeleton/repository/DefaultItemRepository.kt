package com.rmakiyama.skeleton.repository

import com.rmakiyama.skeleton.datasource.ItemDataSource
import com.rmakiyama.skeleton.model.Item

internal class DefaultItemRepository(
    private val dataSource: ItemDataSource,
) : ItemRepository {

    override suspend fun getItemList(): List<Item> {
        return dataSource.getItemList()
    }
}
