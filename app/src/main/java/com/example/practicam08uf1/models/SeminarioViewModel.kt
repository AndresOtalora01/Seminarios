package com.example.practicam08uf1.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.practicam08uf1.room.SeminarioDb
import com.example.practicam08uf1.room.SeminarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeminarioViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Seminario>>
    private val repository: SeminarioRepository

    init {
        val seminarioDao = SeminarioDb.getDatabase(application).seminarioDao()
        repository = SeminarioRepository(seminarioDao)
        readAllData = repository.getAllData
    }


    fun addSeminario(seminario: Seminario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSeminario(seminario)
        }
    }
}