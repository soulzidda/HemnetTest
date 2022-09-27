package com.abassey.hemnettest.di

import com.abassey.hemnettest.network.AdvertNetworkMapper
import com.abassey.hemnettest.network.AdvertService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideAdvertMapper(): AdvertNetworkMapper {
        return AdvertNetworkMapper()
    }

    @Singleton
    @Provides
    fun providesAdvertService(): AdvertService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/soulzidda/220a8305a6437f3be37eae6198f4d0db/raw/bed8d1e25b85741a4e2ff1d88230b0024ba04e13/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(AdvertService::class.java)

    }
}