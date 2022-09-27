package com.abassey.hemnettest.repository

import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.network.AdvertNetworkMapper
import com.abassey.hemnettest.network.AdvertService
import java.io.IOException

class AdvertRepositoryImpl(
    private val advertService: AdvertService, private val mapper: AdvertNetworkMapper
) : AdvertRepository {
    override suspend fun advertList(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit,
    ): List<Advert> {
        var mapped: List<Advert> = listOf()
        try {
            onStart()
            mapped = mapper.fromNetworkList(advertService.getAdvertsList().list)
        } catch (error: IOException) {
            onError(error.localizedMessage as String)
        } finally {
            onCompletion()
        }
        return mapped
    }
}

