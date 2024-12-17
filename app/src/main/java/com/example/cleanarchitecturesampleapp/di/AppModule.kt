package com.example.cleanarchitecturesampleapp.di

import com.example.cleanarchitecturesampleapp.core.util.Constants.BASE_URL
import com.example.cleanarchitecturesampleapp.data.api.CharacterApi
import com.example.cleanarchitecturesampleapp.data.repository.CharacterRepositoryImpl
import com.example.cleanarchitecturesampleapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module

class AppModule {
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    fun provideCharacterRepository(characterApi: CharacterApi): CharacterRepository = CharacterRepositoryImpl(characterApi)
}