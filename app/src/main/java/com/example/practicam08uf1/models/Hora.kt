package com.example.practicam08uf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Hora (
    @SerializedName("inici")
    var hora_inicio: String,
    @SerializedName("final")
    var hora_fin:String) : Serializable