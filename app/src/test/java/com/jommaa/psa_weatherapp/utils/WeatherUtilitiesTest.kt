package com.jommaa.psa_weatherapp.utils

import com.jommaa.psa_weatherapp.R
import org.junit.Assert
import org.junit.Test

class WeatherUtilitiesTest {

    @Test
    fun `return the right wheather icon`(){
        val sunny1 ="01d"
        val sunny2 = "02d"
        val night1 ="01n"
        val night2 ="02n"
        val couverage1="03d"
       val couverage2 = "03n"

        val rain2 = "09n"
        val rain1 = "09d"
        val night3 = "10n"
        val sunny3 ="10d"
        val flash1 ="11d"
        val flash2 = "11n"
        val snow1 = "13d"
        val snow2 = "13n"
        val wind1="50d"
        val wind2 ="50n"

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(sunny1), R.mipmap.sunny1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(sunny2), R.mipmap.sunny2)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(sunny3), R.mipmap.sunny3)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(night1), R.mipmap.night1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(night2), R.mipmap.night2)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(night3), R.mipmap.night3)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(couverage1), R.mipmap.couverage1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(couverage2), R.mipmap.couverage2)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(rain1), R.mipmap.rain1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(rain2), R.mipmap.rain2)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(flash1), R.mipmap.flash1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(flash2), R.mipmap.flash2)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(snow1), R.mipmap.snow1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(snow2), R.mipmap.snow2)

        Assert.assertEquals(WeatherUtilities.getWeatherIcon(wind1), R.mipmap.wind1)
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(wind2), R.mipmap.wind2)

    }

    @Test
    fun `return sunny icon when weather is null`(){
        Assert.assertEquals(WeatherUtilities.getWeatherIcon(null), R.mipmap.sunny1)
    }

    @Test
    fun `return right Hour from timestamp`(){

        val timeStamp1:Long = 1651323600 //Equivalent to 30/04/2022 15:00:00
        val timeStamp2:Long = 1617323600 //Equivalent to 02/04/2021 02:33:20

        Assert.assertEquals(WeatherUtilities.getHourFromMimeStamp(timeStamp1),15)
        Assert.assertEquals(WeatherUtilities.getHourFromMimeStamp(timeStamp2),2)
    }

}