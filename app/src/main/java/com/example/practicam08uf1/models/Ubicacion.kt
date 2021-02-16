package com.example.practicam08uf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Ubicacion(
    @SerializedName("centre")
    var centro: String,
    @SerializedName("adreca")
    var direccion: String,
    @SerializedName("cp")
    var cp: String,
    @SerializedName("ciutat")
    var ciudad: String,
    @SerializedName("provincia")
    var provincia: String
):Serializable