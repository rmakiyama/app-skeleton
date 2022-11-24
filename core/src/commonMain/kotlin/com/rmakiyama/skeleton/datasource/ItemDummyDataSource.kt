package com.rmakiyama.skeleton.datasource

import com.rmakiyama.skeleton.model.Item

internal class ItemDummyDataSource : ItemDataSource {
    override suspend fun getItemList(): List<Item> {
        return items
    }
}

private val items = listOf(
    Item(title = "Title", description = "Description"),
    Item(title = "Android", description = "Android is supported!"),
    Item(title = "iOS", description = "iOS is supported!"),
    Item(title = "Skeleton", description = null),
    Item(title = "Template", description = "template"),
)
