package com.example.practicam08uf1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicam08uf1.R
import com.example.practicam08uf1.databinding.FragmentItemBinding
import com.example.practicam08uf1.databinding.FragmentListBinding


class ItemFragment : Fragment() {
    lateinit var binding: FragmentItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item, container, false)
        binding = FragmentItemBinding.bind(view)
        return binding.root
    }


}