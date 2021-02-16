package com.example.practicam08uf1.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Durada(
    @SerializedName("dies")
    var dias: Int,
    @SerializedName("hores")
    var horas: Int): Serializable