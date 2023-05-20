package com.example.rickyandmortyapi.ui.fragments.characters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickyandmortyapi.App
import com.example.rickyandmortyapi.models.CharacterModel
import com.example.rickyandmortyapi.models.RickyAndMorty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    init {
       Log.e("ViewModel", "Created")
    }

    fun fetchCharacter(): MutableLiveData<RickyAndMorty<CharacterModel>>{
        val data: MutableLiveData<RickyAndMorty<CharacterModel>> = MutableLiveData()
        App.characterApiService?.fetchCharacter()?.enqueue(object :
            Callback<RickyAndMorty<CharacterModel>>{
            override fun onResponse(
                call: Call<RickyAndMorty<CharacterModel>>,
                response: Response<RickyAndMorty<CharacterModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(
                call: Call<RickyAndMorty<CharacterModel>>,
                t: Throwable)
                {
                data.value = null
            }

        })
        return  data
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("ViewModel", "Cleared")
    }
}