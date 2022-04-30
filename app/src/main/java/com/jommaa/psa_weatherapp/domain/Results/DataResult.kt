package com.jommaa.psa_weatherappapplication.domain.Results

import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails

sealed class DataResult {
    object Loading : DataResult()
    data class TownsListResult(val list: List<Town>?) : DataResult()
    data class TownResult(val town: Town) : DataResult()
    data class WeatherDetailsResult(val details: WeatherDetails) : DataResult()
    data class Failure(val throwable: Throwable) : DataResult()
}