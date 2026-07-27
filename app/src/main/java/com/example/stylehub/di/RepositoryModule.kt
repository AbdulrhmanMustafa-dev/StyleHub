package com.example.stylehub.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCartRepository(
        cartRepositoryImpl: com.example.stylehub.data.repositoryImpl.CartRepositoryImpl
    ): com.example.stylehub.domain.repository.CartRepository
}
