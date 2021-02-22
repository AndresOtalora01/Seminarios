package com.example.practicam08uf1.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        return
    }

}