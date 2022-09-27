package com.abassey.hemnettest.ui.shared

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.repository.AdvertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdvertViewModel @Inject constructor(
    private val repository: AdvertRepository,
) : ViewModel() {
    var isLoading: Boolean = false
    val error: MutableState<String?> = mutableStateOf(null)
    val adverts: MutableState<List<Advert>> = mutableStateOf(listOf())

    init {
        fetchData()
    }

    private fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = repository.advertList(onStart = { isLoading = true },
                onCompletion = { isLoading = false },
                onError = { message -> error.value = message })
            adverts.value = result
        }
    }

    fun filterAdverts(advertId: String): Advert? {
        return adverts.value.find { it.id == advertId }
    }
}