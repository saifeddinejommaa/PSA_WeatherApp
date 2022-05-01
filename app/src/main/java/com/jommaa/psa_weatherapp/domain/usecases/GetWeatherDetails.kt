package com.example.domain.domain.usecases

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jommaa.psa_weatherapp.db.datasource.WeatherDetailsDataSource
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.psa_weatherapp.domain.repository.IWeatherRepository
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import java.lang.Exception
import javax.inject.Inject

class GetWeatherDetails @Inject  constructor(val repository: IWeatherRepository,private val weatherDetailsDataSource: WeatherDetailsDataSource) {

    /**
     * @u
     *
     */
    fun getWeatherDetails(townId:Int,lat: Double, lng: Double, units: String): LiveData<DataResult> = liveData{
         val details= repository.getWeatherDetails(townId,lat,lng,units)
         emit(details)
    }

    suspend fun insertWeatherDetails(weatherDetails: WeatherDetails){
        repository.insertWeatherDetails(weatherDetails)
    }

    fun getWeatherDetailFromDB(townId:Int):LiveData<DataResult> {
        return repository.getWeatherDetailsFromDB(townId)

    }
}