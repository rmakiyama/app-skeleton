package com.rmakiyama.skeleton.usecase.di

import com.rmakiyama.skeleton.repository.ItemRepository
import com.rmakiyama.skeleton.usecase.GetItemList
import com.rmakiyama.skeleton.usecase.GetItemListUseCase

class UseCaseModule(
    private val itemRepository: ItemRepository,
) {

    fun provideGetItemList(): GetItemList {
        return GetItemListUseCase(
            itemRepository = itemRepository,
        )
    }
}
