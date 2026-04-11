package com.rmakiyama.skeleton.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.skeleton.domain.Item
import com.rmakiyama.skeleton.usecase.GetItemsStreamUseCase
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@ContributesIntoMap(AppScope::class)
@ViewModelKey
@Inject
class HomeViewModel(
    private val getItemsStreamUseCase: GetItemsStreamUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        observeItems()
    }

    private fun observeItems() {
        viewModelScope.launch {
            getItemsStreamUseCase()
                .collect { itemList ->
                    _uiState.update { it.copy(items = itemList) }
                }
        }
    }
}

data class HomeUiState(
    val items: List<Item> = emptyList(),
)
