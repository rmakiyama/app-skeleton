package com.rmakiyama.skeleton.di

import com.rmakiyama.skeleton.usecase.GetItemList
import com.rmakiyama.skeleton.usecase.di.UseCaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    private val useCaseModule = UseCaseModule()

    @Provides
    fun provideGetItemListUseCase(): GetItemList = useCaseModule.provideGetItemList()
}
