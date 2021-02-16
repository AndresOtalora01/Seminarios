package com.example.practicam08uf1.room

import androidx.lifecycle.LiveData
import com.example.practicam08uf1.models.Seminario

class SeminarioRepository (private var seminarioDao: SeminarioDao) {

    var getAllData : LiveData<List<Seminario>> = seminarioDao.getAllSeminarios()

    suspend fun addSeminario (seminario: Seminario) {
        seminarioDao.addSeminario(seminario)
    }

}