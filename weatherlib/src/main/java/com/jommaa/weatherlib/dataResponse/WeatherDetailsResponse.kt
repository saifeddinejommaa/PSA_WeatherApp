package com.jommaa.weatherlib.dataResponse


data class WeatherDetailsResponse(

    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: CurrentResponse?,
    val minutely: List<MinutelyResponse>?,
    val hourly: List<CurrentResponse>?)

{

}