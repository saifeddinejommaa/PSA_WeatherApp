package com.jommaa.weatherlib

import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query
interface WeatherEndPoint {
    @GET("onecall")
   suspend fun getWeatherDetails(@Query("lat") lat: Double, @Query("lon") lng: Double,@Query("exclude")exclude:String, @Query("appid")appKey: String,@Query("units") units: String): WeatherDetailsResponse

}