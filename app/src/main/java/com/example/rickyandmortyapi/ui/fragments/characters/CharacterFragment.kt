package com.example.rickyandmortyapi.ui.fragments.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickyandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickyandmortyapi.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private val viewModel by viewModels<CharacterViewModel>()
    private var binding: FragmentCharacterBinding? = null
    private var characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserv()
    }

    private fun setUpObserv() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
            characterAdapter.setList(it.results)
        }
    }

    private fun initialize() {
        binding?.recyclerCharacter?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}