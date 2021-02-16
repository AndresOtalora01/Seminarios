package com.example.practicam08uf1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practicam08uf1.models.MyTypeConverters
import com.example.practicam08uf1.models.Seminario

@TypeConverters(MyTypeConverters::class)
@Database(entities = [Seminario::class], version = 1, exportSchema = false)
abstract class SeminarioDb : RoomDatabase() {

    abstract fun seminarioDao(): SeminarioDao


    companion object {
        @Volatile
        private var INSTANCE: SeminarioDb? = null

        fun getDatabase(context: Context): SeminarioDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SeminarioDb::class.java,
                    "seminario_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}