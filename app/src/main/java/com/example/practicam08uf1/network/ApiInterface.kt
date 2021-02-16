package com.example.practicam08uf1.network

import com.example.practicam08uf1.models.Seminario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getSeminarios(@Url url: String): Call<List<Seminario>>
}