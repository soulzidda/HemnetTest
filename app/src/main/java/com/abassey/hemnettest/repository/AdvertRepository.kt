package com.abassey.hemnettest.repository

import com.abassey.hemnettest.models.Advert

interface AdvertRepository {
    suspend fun advertList(
        onStart: () -> Unit, onCompletion: () -> Unit, onError: (String) -> Unit
    ): List<Advert>
}