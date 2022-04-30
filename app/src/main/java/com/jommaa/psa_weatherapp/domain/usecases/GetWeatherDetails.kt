package com.example.domain.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jommaa.psa_weatherapp.domain.repository.IWeatherRepository
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import javax.inject.Inject

class GetWeatherDetails @Inject  constructor(val repository: IWeatherRepository) {

    /**
     * @u
     *
     */
    fun getWeatherDetails(lat: Double, lng: Double, units: String): LiveData<DataResult> = liveData{
         val details= repository.getWeatherDetails(lat,lng,units)
         emit(details)
    }
}