package com.jommaa.psa_weatherapp.domain.entities

import com.google.gson.annotations.SerializedName

data class Current(
    override val dt : Long,
    override val sunrise :Long,
    override val sunset : Long,
    override val pressure: Int,
    override val humidity: Int,
    @SerializedName("dew_point")
    override val dewPoint: Float,
    override val uvi: Float,
    override val clouds: Int,
    @SerializedName("wind_speed")
    override val windSpeed: Float,
    @SerializedName("wind_deg")
    override val winDeg: Int,
    @SerializedName("weather")
    override val weather: List<Weather>?,
    val temp : Float,
    @SerializedName("feels_like")
    val feelLike : Float,
    val visibility: Int
) : WeatherStatus(dt, sunrise,sunset,pressure,humidity,dewPoint,uvi,clouds,windSpeed,winDeg,weather) {
}