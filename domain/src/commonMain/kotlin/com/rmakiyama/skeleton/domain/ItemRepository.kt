package com.rmakiyama.skeleton.domain

import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItemsStream(): Flow<List<Item>>
    suspend fun save(item: Item)
}
