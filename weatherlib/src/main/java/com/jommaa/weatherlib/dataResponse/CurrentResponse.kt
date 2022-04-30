package com.jommaa.weatherlib.dataResponse


data class CurrentResponse(
    val dt : Long,
    val sunrise :Long,
    val sunset : Long,
    val pressure: Int,
    val humidity: Int,
      val dewPoint: Float,
    val uvi: Float,
    val clouds: Int,
      val windSpeed: Float,
      val winDeg: Int,
      val weather: List<WeatherResponse>?,
    val temp : Float,
    val feelLike : Float,
    val visibility: Int
)  {
}