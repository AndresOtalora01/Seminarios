package com.example.practicam08uf1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicam08uf1.R
import com.example.practicam08uf1.databinding.FragmentAboutBinding
import com.example.practicam08uf1.databinding.FragmentItemBinding


class AboutFragment : Fragment() {
    lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        binding = FragmentAboutBinding.bind(view)

        binding.cardView.setOnClickListener {
            binding.cardView.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.cardView.animate().apply {
                    duration = 1000
                    rotationXBy(720f)
                }.start()
            }
        }


        return binding.root
    }


}