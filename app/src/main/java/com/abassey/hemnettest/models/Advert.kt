package com.abassey.hemnettest.models

import androidx.compose.runtime.Immutable

@Immutable
data class Advert(
    val id: String? = null,
    val type: String? = null,
    val askingPrice: String? = null,
    val monthlyFee: String? = null,
    val municipality: String? = null,
    val area: String? = null,
    val daysOnHemnet: Int? = null,
    val livingArea: Short? = null,
    val numberOfRooms: Int? = null,
    val streetAddress: String? = null,
    val image: String? = null,
    val rating: String? = null,
    val averagePrice: String? = null
) {
    companion object {
        fun mock() = Advert(
            id = "1234567890",
            type = "HighlightedProperty",
            askingPrice = "2 650 000 kr",
            monthlyFee = "1 498 kr/mån",
            municipality = "Gällivare kommun",
            area = "Heden",
            daysOnHemnet = 1,
            livingArea = 120,
            numberOfRooms = 5,
            streetAddress = "Mockvägen 1",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Hus_i_svarttorp.jpg/800px-Hus_i_svarttorp.jpg"
        )
    }
}
