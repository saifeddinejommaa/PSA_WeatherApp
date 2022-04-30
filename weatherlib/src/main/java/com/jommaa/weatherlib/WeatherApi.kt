package com.jommaa.weatherlib


import com.jommaa.weatherlib.consts.Consts
import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse


class WeatherApi constructor(private val weatherEndPoint: WeatherEndPoint) {

  suspend fun getWeatherDetails(lat: Double,lng: Double,units: String) : WeatherDetailsResponse {
      return weatherEndPoint.getWeatherDetails(lat,lng,"current", Consts.APP_KEY,units)
  }
}