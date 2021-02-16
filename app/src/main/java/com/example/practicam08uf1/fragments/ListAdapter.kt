package com.example.practicam08uf1.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practicam08uf1.R
import com.example.practicam08uf1.models.Seminario
import kotlinx.android.synthetic.main.fragment_item.view.*
import kotlinx.android.synthetic.main.seminario_row.view.*

class ListAdapter(private val listener: OnSeminarioClickListener) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var listaSeminarios = emptyList<Seminario>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onSeminarioClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.seminario_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = listaSeminarios[position]

        if (!currentItem.logo.isEmpty() || currentItem.logo != null) {
            Glide.with(holder.itemView.context)
                .load(currentItem.logo)
                .placeholder(R.drawable.animated_progress)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.itemView.ivLogo)
        } else {
            holder.itemView.ivLogo.setImageResource(R.drawable.image_not_found)
        }
        holder.itemView.tvNumeroSeminario.text = currentItem.numero_seminario.toString()
        holder.itemView.tvTitulo.text = currentItem.titulo
        holder.itemView.tvEmpresaOrganizadora.text = currentItem.empresa_organizadora
    }

    override fun getItemCount(): Int {
        return listaSeminarios.size
    }

    fun setData(seminario: List<Seminario>) {
        listaSeminarios = seminario
        notifyDataSetChanged()
    }

    interface OnSeminarioClickListener {
        fun onSeminarioClick(position: Int)
    }
}