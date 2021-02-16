package com.example.practicam08uf1.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.practicam08uf1.models.Seminario

@Dao
interface SeminarioDao {

    @Query("SELECT * FROM Seminario")
    fun getAllSeminarios(): LiveData<List<Seminario>>

    @Query("SELECT * FROM Seminario WHERE numero_seminario = :numeroSeminario")
    fun getByNumeroSeminario(numeroSeminario: Int): Seminario

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun addSeminario(seminario: Seminario)
}