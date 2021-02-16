package com.example.practicam08uf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Fecha (
    @SerializedName("inici")
    var fecha_inicio:String,
    @SerializedName("final")
    var fecha_fin:String): Serializable