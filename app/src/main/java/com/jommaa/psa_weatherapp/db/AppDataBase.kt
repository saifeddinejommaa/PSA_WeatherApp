package com.jommaa.psa_weatherapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.datacomponent.db.dao.TownDao

@Database(entities = arrayOf(Town::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun TownDao(): TownDao
        companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "weather.db")
            .build()
    }
    }
