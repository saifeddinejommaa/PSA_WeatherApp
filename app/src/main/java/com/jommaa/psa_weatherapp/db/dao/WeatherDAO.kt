package com.jommaa.psa_weatherapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.psa_weatherapp.domain.entities.Weather

@Dao
interface WeatherDAO {

    @Query("SELECT * FROM weather WHERE parentId=:prentId")
    fun loadById(prentId: Int): List<Weather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( vararg weather: Weather?)

    @Delete
    fun delete(weather: Weather)
}