package com.abassey.hemnettest.network

import com.abassey.hemnettest.models.NetworkResponse
import retrofit2.http.GET

interface AdvertService {
    @GET("adverts.json")
    suspend fun getAdvertsList(): NetworkResponse
}