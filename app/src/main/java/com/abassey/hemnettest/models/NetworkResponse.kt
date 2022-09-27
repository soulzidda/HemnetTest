package com.abassey.hemnettest.models

import com.squareup.moshi.Json

class NetworkResponse(
    @Json(name = "list") var list: List<ResponseAdvertModel>
)