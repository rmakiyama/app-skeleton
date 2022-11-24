package com.rmakiyama.skeleton.usecase.di

import com.rmakiyama.skeleton.repository.di.RepositoryModule
import com.rmakiyama.skeleton.usecase.GetItemList
import com.rmakiyama.skeleton.usecase.GetItemListUseCase

class UseCaseModule(
    private val repositoryModule: RepositoryModule = RepositoryModule(),
) {

    fun provideGetItemList(): GetItemList {
        return GetItemListUseCase(
            itemRepository = repositoryModule.provideItemRepository(),
        )
    }

    companion object {
        // for Swift
        fun get() = UseCaseModule()
    }
}
