package com.abassey.hemnettest.utils

interface NetworkMapperHelper<ResponseAdvertModal, ObjectModel> {
    fun mapFromNetworkResponse(response: ResponseAdvertModal): ObjectModel
}