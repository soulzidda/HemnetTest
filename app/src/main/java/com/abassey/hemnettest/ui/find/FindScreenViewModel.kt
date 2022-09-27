package com.abassey.hemnettest.ui.find

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.repository.AdvertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindScreenViewModel @Inject constructor(
    private val repository: AdvertRepository,
) : ViewModel() {

    val adverts: MutableState<List<Advert>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            val result = repository.advertList()
            adverts.value = result
        }
    }
}