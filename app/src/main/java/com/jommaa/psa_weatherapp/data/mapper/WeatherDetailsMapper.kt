package com.jommaa.psa_weatherapp.data.mapper


import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse
import javax.inject.Inject

class WeatherDetailsMapper  @Inject constructor(val currentMapper : CurrentMapper, val minutelyMapper: MinutelyMapper ) {

    fun toWeatherDetails(townId:Int,resp:WeatherDetailsResponse): WeatherDetails{
        return WeatherDetails( resp.lat,
            resp.lon,
            resp.timezone,
            resp.timezoneOffset,
            resp.current?.let{currentMapper.toCurrent(resp.current!!)},
            resp.minutely?.map { minutelyMapper.toMinutely(it) },
            resp.hourly?.map { currentMapper.toCurrent(it) },townId)
    }
}