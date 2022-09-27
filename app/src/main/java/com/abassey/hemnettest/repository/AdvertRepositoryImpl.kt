package com.abassey.hemnettest.repository

import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.network.AdvertNetworkMapper
import com.abassey.hemnettest.network.AdvertService

class AdvertRepositoryImpl(
    private val advertService: AdvertService,
    private val mapper: AdvertNetworkMapper
) : AdvertRepository {

    override suspend fun advertList(): List<Advert> {
        return mapper.fromNetworkList(advertService.getAdvertsList().list)
    }
}