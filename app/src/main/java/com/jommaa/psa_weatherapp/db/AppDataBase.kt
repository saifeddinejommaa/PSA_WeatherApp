package com.jommaa.psa_weatherapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.datacomponent.db.dao.TownDao
import com.jommaa.psa_weatherapp.db.dao.CurrentDAO
import com.jommaa.psa_weatherapp.db.dao.WeatherDAO
import com.jommaa.psa_weatherapp.db.dao.WeatherDetailsDao
import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.psa_weatherapp.domain.entities.Weather
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails

@Database(entities = arrayOf(Town::class,WeatherDetails::class,Current::class,Weather::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun TownDao(): TownDao
        abstract fun WeatherDetailsDao(): WeatherDetailsDao
        abstract fun CurrentDAO(): CurrentDAO
        abstract fun WeatherDAO(): WeatherDAO
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
