package com.example.rickyandmortyapi.ui.fragments.characters.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickyandmortyapi.App
import com.example.rickyandmortyapi.models.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDetailViewModel : ViewModel() {

    fun fetchSingleCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiService?.fetchSingleCharacter(id)
            ?.enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                    data.value = null
                    Log.e("error", t.localizedMessage ?: "Error")
                }
            })
        return data
    }
}