package com.abassey.hemnettest.repository

import com.abassey.hemnettest.models.Advert

interface AdvertRepository {

    suspend fun advertList(): List<Advert>
}