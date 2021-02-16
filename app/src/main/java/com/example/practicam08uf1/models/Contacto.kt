package com.example.practicam08uf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Contacto(
    @SerializedName("nom")
    var nombre: String,
    @SerializedName("carrec")
    var cargo: String,
    @SerializedName("telefon")
    var telefono: String,
    @SerializedName("email")
    var email: String
) : Serializable