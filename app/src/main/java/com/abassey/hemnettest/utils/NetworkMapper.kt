package com.abassey.hemnettest.utils

interface NetworkMapper<ResponseAdvertModal, ObjectModel> {
    fun mapFromNetworkResponse(response: ResponseAdvertModal): ObjectModel
}