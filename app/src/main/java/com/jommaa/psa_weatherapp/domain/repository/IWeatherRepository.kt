package com.jommaa.psa_weatherapp.domain.repository


import androidx.lifecycle.LiveData
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult

interface IWeatherRepository {
    suspend fun getWeatherDetails(townId:Int,lat: Double, lng: Double, units: String): DataResult

    fun getWeatherDetailsFromDB(townId:Int): LiveData<DataResult>

    suspend fun insertWeatherDetails(weatherDetails:WeatherDetails)
}
