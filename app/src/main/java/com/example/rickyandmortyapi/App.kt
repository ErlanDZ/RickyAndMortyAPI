package com.example.rickyandmortyapi

import android.app.Application
import com.example.rickyandmortyapi.data.remote.apiservices.CharacterApiService
import com.example.rickyandmortyapi.data.remote.RetrofitClient

class App : Application(){
    companion object{
        var characterApiService: CharacterApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = RetrofitClient().provideCharacterApiService()
    }
}