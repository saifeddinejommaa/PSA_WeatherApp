package com.jommaa.psa_weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.usecases.GetWeatherDetails
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel  @Inject  constructor(val useCase: GetWeatherDetails) : ViewModel() {

    var details:LiveData<DataResult>? = null

     fun getWeatherDetail(town: Town) {
         details = useCase.getWeatherDetails(town.id,town.lat, town.lon, "metric")
    }

    fun getLocalWeatherDetails(townId:Int){
        details = useCase.getWeatherDetailFromDB(townId)
    }

     fun  insertWeatherDetails(weatherDetails: WeatherDetails){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.insertWeatherDetails(weatherDetails)
        }
    }

}