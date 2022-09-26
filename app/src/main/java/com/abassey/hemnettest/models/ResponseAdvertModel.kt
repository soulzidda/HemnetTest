package com.abassey.hemnettest.models

import com.squareup.moshi.Json

class ResponseAdvertModel(

    @Json(name = "type")
    var type: String? = null,

    @Json(name = "id")
    var id: String? = null,

    @Json(name = "askingPrice")
    var askingPrice: String? = null,

    @Json(name = "monthlyFee")
    var monthlyFee: String? = null,

    @Json(name = "municipality")
    var municipality: String? = null,

    @Json(name = "area")
    var area: String? = null,

    @Json(name = "daysOnHemnet")
    var daysOnHemnet: Int? = null,

    @Json(name = "livingArea")
    var livingArea: Short? = null,

    @Json(name = "numberOfRooms")
    var numberOfRooms: Int? = null,

    @Json(name = "streetAddress")
    var streetAddress: String? = null,

    @Json(name = "image")
    var image: String? = null,
)