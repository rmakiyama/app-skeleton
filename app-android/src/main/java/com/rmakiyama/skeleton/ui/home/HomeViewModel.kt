package com.rmakiyama.skeleton.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmakiyama.skeleton.model.Item
import com.rmakiyama.skeleton.usecase.GetItemList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getItemList: GetItemList,
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            val items = getItemList()
            _state.update { it.copy(items = items) }
        }
    }

    data class State(
        val items: List<Item> = emptyList(),
    )
}
