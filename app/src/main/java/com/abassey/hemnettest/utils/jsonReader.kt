package com.abassey.hemnettest.utils

import android.content.Context
import com.abassey.hemnettest.models.Advert
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


fun loadDataFromJson(context: Context): List<Advert>? {
    val jsonFilePath = "advertData.json"
    val json = context.assets.open(jsonFilePath).bufferedReader().use { it.readText() }
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val listType = Types.newParameterizedType(List::class.java, Advert::class.java)
    val adapter: JsonAdapter<List<Advert>> = moshi.adapter(listType)

    return adapter.fromJson(json)
}