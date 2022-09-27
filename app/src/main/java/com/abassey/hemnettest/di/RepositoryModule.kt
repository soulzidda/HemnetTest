package com.abassey.hemnettest.di

import com.abassey.hemnettest.network.AdvertNetworkMapper
import com.abassey.hemnettest.network.AdvertService
import com.abassey.hemnettest.repository.AdvertRepository
import com.abassey.hemnettest.repository.AdvertRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAdvertRepository(
        advertService: AdvertService,
        advertNetworkMapper: AdvertNetworkMapper,
    ): AdvertRepository {
        return AdvertRepositoryImpl(advertService, advertNetworkMapper)
    }
}