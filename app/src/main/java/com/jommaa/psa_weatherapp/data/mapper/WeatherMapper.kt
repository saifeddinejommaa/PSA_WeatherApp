package com.jommaa.psa_weatherapp.data.mapper


import com.jommaa.psa_weatherapp.domain.entities.Weather
import com.jommaa.weatherlib.dataResponse.WeatherResponse
import javax.inject.Inject

open class WeatherMapper  @Inject constructor() {

    fun toWeather(resp:WeatherResponse):Weather{
        return Weather(resp.id,
            resp.main,
            resp.description,
            resp.icon)
    }
}