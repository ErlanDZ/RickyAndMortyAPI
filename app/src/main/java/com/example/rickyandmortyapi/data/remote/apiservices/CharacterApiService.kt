package com.example.rickyandmortyapi.data.remote.apiservices

import com.example.rickyandmortyapi.models.CharacterModel
import com.example.rickyandmortyapi.models.RickyAndMorty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacter(): Call<RickyAndMorty<CharacterModel>>

    @GET("api/character/{id}")
    fun fetchSingleCharacter(
        @Path("id") id: Int
    ): Call<CharacterModel>
}