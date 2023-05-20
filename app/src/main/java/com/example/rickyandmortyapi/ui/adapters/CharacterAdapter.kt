package com.example.rickyandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickyandmortyapi.databinding.ItemCharacterBinding
import com.example.rickyandmortyapi.models.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }


    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
//            binding.imageCharacter.setImage(characterModel.image)
            binding.txtNameCharacter.text = characterModel.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}