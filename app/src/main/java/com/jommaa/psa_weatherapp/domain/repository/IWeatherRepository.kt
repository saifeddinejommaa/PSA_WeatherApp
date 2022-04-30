package com.jommaa.psa_weatherapp.domain.repository


import com.jommaa.psa_weatherappapplication.domain.Results.DataResult

interface IWeatherRepository {
    suspend fun getWeatherDetails(lat: Double, lng: Double, units: String): DataResult
}
