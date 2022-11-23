package com.rmakiyama.skeleton.usecase

import com.rmakiyama.skeleton.model.Item
import com.rmakiyama.skeleton.repository.ItemRepository

interface GetItemList {
    suspend operator fun invoke(): List<Item>
}

internal class GetItemListUseCase(
    private val itemRepository: ItemRepository,
) : GetItemList {
    override suspend operator fun invoke(): List<Item> {
        return itemRepository.getItemList()
    }
}
