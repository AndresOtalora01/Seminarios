package com.example.practicam08uf1.models

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practicam08uf1.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Entity(tableName = "seminario")
data class Seminario(
    @SerializedName("numero_seminari")
    @PrimaryKey()
    var numero_seminario: Int,
    @SerializedName("titol")
    var titulo: String,
    @SerializedName("descripcio")
    var descripcion: String,
    @SerializedName("empresa_organitzadora")
    var empresa_organizadora: String,
    @SerializedName("places_reservades")
    var plazas_reservadas: Int,
    @SerializedName("ubicacio")
    var ubicacion: Ubicacion,
    @SerializedName("durada")
    var durada: Durada,
    @SerializedName("data")
    var fecha: Fecha,
    @SerializedName("hora")
    var hora: Hora,
    @SerializedName("contacte")
    var contacto: Contacto,
    @SerializedName("comentaris")
    var comentarios: String,
    @SerializedName("logo")
    var logo: String
) : Serializable {
    companion object {
        @JvmStatic @BindingAdapter("android:imagen")
        fun loadImage(imageView: ImageView, imageUrl: String) {
            Glide.with(imageView)
                .load(imageUrl)
                .placeholder(R.drawable.animated_progress)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView)
        }
    }
}
