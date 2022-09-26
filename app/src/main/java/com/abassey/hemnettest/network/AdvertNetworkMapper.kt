package com.abassey.hemnettest.network

import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.models.ResponseAdvertModel
import com.abassey.hemnettest.utils.NetworkMapper

class AdvertNetworkMapper : NetworkMapper<ResponseAdvertModel, Advert> {
    override fun mapFromNetworkResponse(response: ResponseAdvertModel): Advert {
        return Advert(
            id = response.id,
            type = response.type,
            askingPrice = response.askingPrice,
            monthlyFee = response.monthlyFee,
            municipality = response.municipality,
            area = response.area,
            daysOnHemnet = response.daysOnHemnet,
            livingArea = response.livingArea,
            numberOfRooms = response.numberOfRooms,
            streetAddress = response.streetAddress,
            image = response.image
        )
    }

    fun fromNetworkList(initialValue: List<ResponseAdvertModel>): List<Advert> {
        return initialValue.map { mapFromNetworkResponse(it) }
    }

}