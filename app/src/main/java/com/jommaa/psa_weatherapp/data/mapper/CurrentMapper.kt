package com.jommaa.psa_weatherapp.data.mapper

import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.weatherlib.dataResponse.CurrentResponse
import javax.inject.Inject

open class CurrentMapper  @Inject constructor(val weatherMapper: WeatherMapper){

   open fun toCurrent(resp: CurrentResponse?): Current?{
        resp?.let {
            var current = Current(
                resp.dt,
                resp.sunrise,
                resp.sunset,
                resp.pressure,
                resp.humidity,
                resp.dewPoint,
                resp.uvi,
                resp.clouds,
                resp.windSpeed,
                resp.winDeg, resp.temp, resp.feelLike, resp.visibility, 0
            )
            current.weather = resp.weather?.map { weatherMapper.toWeather(current.id,it) }
           return current;
        }
        return null
    }
}