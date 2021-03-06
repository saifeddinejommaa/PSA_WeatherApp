package com.jommaa.psa_weatherapp.domain.entities
  open abstract class WeatherStatus(
      open val dt : Long,
      open val sunrise :Long,
      open val sunset : Long,
      open val pressure: Int,
      open val humidity: Int,
      open val dewPoint: Float,
      open val uvi: Float,
      open val clouds: Int,
      open val windSpeed: Float,
      open val winDeg: Int,
      open val weather: List<Weather>? ) {
}