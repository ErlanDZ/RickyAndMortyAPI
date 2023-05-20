package com.example.rickyandmortyapi.models

import com.google.gson.annotations.SerializedName

data class RickyAndMorty<T>(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>
)
