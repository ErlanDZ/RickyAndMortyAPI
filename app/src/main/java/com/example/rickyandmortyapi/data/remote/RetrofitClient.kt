package com.example.rickyandmortyapi.data.remote

import com.example.rickyandmortyapi.data.remote.apiservices.CharacterApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }
}