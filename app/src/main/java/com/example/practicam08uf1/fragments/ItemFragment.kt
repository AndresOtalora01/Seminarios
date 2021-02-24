package com.example.practicam08uf1.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practicam08uf1.R
import com.example.practicam08uf1.databinding.FragmentItemBinding
import com.example.practicam08uf1.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.seminario_row.view.*


class ItemFragment : Fragment() {
    //    lateinit var binding: FragmentItemBinding
    private val args by navArgs<ItemFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentItemBinding: FragmentItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_item, container, false)
        setHasOptionsMenu(true)
        fragmentItemBinding.seminario = args.seminario
//        val view = inflater.inflate(R.layout.fragment_item, container, false)
//        binding = FragmentItemBinding.bind(view)
//
//        binding.apply {
//            Glide.with(this@ItemFragment)
//                .load(args.seminario.logo)
//                .placeholder(R.drawable.animated_progress)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(ivImagen)
//            tvNumero.text = "Número seminario: ${args.seminario.numero_seminario}"
//            tvTitle.text = args.seminario.titulo
//            tvCentre.text =  args.seminario.ubicacion.centro
//            tvAdreca.text = "Dirección: ${args.seminario.ubicacion.direccion}"
//            tvCP.text = "CP: ${args.seminario.ubicacion.cp}"
//            tvCiutat.text = "Ciudad: ${args.seminario.ubicacion.ciudad}"
//            tvProvincia.text = "Provincia: ${args.seminario.ubicacion.provincia}"
//            tvEmpresa.text = args.seminario.empresa_organizadora
//        }
//
//        return binding.root
        return fragmentItemBinding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        return
    }

}