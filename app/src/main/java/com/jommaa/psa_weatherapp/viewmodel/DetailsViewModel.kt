package com.jommaa.psa_weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.usecases.GetWeatherDetails
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel  @Inject  constructor(val useCase: GetWeatherDetails) : ViewModel() {

    var details:LiveData<DataResult>? = null

     fun getWeatherDetail(town: Town) {
         details = useCase.getWeatherDetails(town.lat, town.lon, "metric")
    }

}