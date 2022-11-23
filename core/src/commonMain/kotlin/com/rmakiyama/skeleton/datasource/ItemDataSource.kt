package com.rmakiyama.skeleton.datasource

import com.rmakiyama.skeleton.model.Item

interface ItemDataSource {
    suspend fun getItemList(): List<Item>
}
