package com.rmakiyama.skeleton.repository

import com.rmakiyama.skeleton.model.Item

interface ItemRepository {
    suspend fun getItemList(): List<Item>
}
