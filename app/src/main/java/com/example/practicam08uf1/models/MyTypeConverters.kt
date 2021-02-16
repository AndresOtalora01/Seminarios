package com.example.practicam08uf1.models

import androidx.room.TypeConverter
import com.google.gson.Gson

class MyTypeConverters {

    @TypeConverter
    fun contactoToString(contacto: Contacto):String = Gson().toJson(contacto)

    @TypeConverter
    fun stringToContacto(string: String):Contacto = Gson().fromJson(string, Contacto::class.java)


    @TypeConverter
    fun duradaToString(durada: Durada):String = Gson().toJson(durada)

    @TypeConverter
    fun stringToDurada(string: String):Durada = Gson().fromJson(string, Durada::class.java)


    @TypeConverter
    fun fechaToString(fecha: Fecha):String = Gson().toJson(fecha)

    @TypeConverter
    fun stringToFecha(string: String):Fecha = Gson().fromJson(string, Fecha::class.java)

    @TypeConverter
    fun horaToString(hora: Hora):String = Gson().toJson(hora)

    @TypeConverter
    fun stringToHora(string: String):Hora = Gson().fromJson(string, Hora::class.java)

    @TypeConverter
    fun ubicacionToString(ubicacion: Ubicacion):String = Gson().toJson(ubicacion)

    @TypeConverter
    fun stringToUbicacion(string: String):Ubicacion = Gson().fromJson(string, Ubicacion::class.java)


}