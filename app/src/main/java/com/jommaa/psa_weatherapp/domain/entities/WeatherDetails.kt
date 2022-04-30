package com.jommaa.psa_weatherapp.domain.entities


data class WeatherDetails(

    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: Current?,
    val minutely: List<Minutely?>?,
    val hourly: List<Current?>?
)

{

}