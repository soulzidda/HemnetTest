package com.abassey.hemnettest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.abassey.hemnettest.network.AdvertService
import com.abassey.hemnettest.ui.theme.HemnetTestTheme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val service =
            Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/soulzidda/220a8305a6437f3be37eae6198f4d0db/raw/bed8d1e25b85741a4e2ff1d88230b0024ba04e13/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build().create(AdvertService::class.java)

        CoroutineScope(IO).launch {
            val advert = service.getAdvertsList()
            Log.d("MainActivity", "OnCreate: ${advert.list[0].id}")
        }

        setContent {
            HemnetTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HemnetApp()
                }
            }
        }
    }
}

