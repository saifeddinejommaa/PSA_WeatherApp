package com.jommaa.weatherlib.dataResponse


class DailyResponse(
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
     val weatherResponse: Array<WeatherResponse>,
    val pop: Float,
    val temp : WeathlySequenceResponse,
    val feelLike : WeathlySequenceResponse,
    val visibility: Int
)  {
}