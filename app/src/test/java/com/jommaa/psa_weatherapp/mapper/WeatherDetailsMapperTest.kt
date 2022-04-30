package com.jommaa.psa_weatherapp.mapper

import com.jommaa.psa_weatherapp.data.mapper.CurrentMapper
import com.jommaa.psa_weatherapp.data.mapper.MinutelyMapper
import com.jommaa.psa_weatherapp.data.mapper.WeatherDetailsMapper
import com.jommaa.psa_weatherapp.data.mapper.WeatherMapper
import com.jommaa.weatherlib.dataResponse.CurrentResponse
import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.any


class WeatherDetailsMapperTest {



    @Mock
    private lateinit var weatherMapper: WeatherMapper

    @Mock
    private lateinit var minutelyMapper: MinutelyMapper


    fun getFakeCurrentResponse():CurrentResponse{
        val pressure = 10
        val humidity = 20
        val temp=30f
        val visibility=60
        return CurrentResponse(
            dt = 12000,
            sunrise = 0,
            sunset =0,
            pressure=pressure,
            humidity=humidity,
            dewPoint=0f,
            uvi=0f,
            clouds=0,
            windSpeed=0f,
            winDeg=0,
            weather=null,
            temp=temp,
            feelLike =0f,
            visibility=visibility)
    }

    @Test
    fun `check weather details mapper`() {

        val lat =12000.00
        val lng =12000.00
        val unit = "metric"
        val townName = "Paris"
        val timezone = "America/Chicago"
        val timezoneOffset =-18000

        val WeatherDetailsResponse= WeatherDetailsResponse(lat,
            lng,
        timezone,
        timezoneOffset,
        getFakeCurrentResponse(),
        null,
        null)

        weatherMapper = mock()
        minutelyMapper = mock ()
        val currentMapper = CurrentMapper(weatherMapper)

       val  mapper = WeatherDetailsMapper(currentMapper,minutelyMapper)

        val mappedWeatherDetails = mapper.toWeatherDetails(WeatherDetailsResponse)

        Assert.assertEquals(mappedWeatherDetails.lat,lat,1e-15)
        Assert.assertEquals(mappedWeatherDetails.lon,lng,1e-15)
       }
    }
