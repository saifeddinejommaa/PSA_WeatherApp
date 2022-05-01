package com.jommaa.psa_weatherapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails

@Dao
interface WeatherDetailsDao {

    @Query("SELECT * FROM weatherDetails WHERE townId=:townId")
    fun loadById(townId: Int): LiveData<WeatherDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherDetails: WeatherDetails?):Long

    @Delete
    fun delete(weatherDetails: WeatherDetails)
}