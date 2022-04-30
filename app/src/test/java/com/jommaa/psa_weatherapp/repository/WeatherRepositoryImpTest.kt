package com.jommaa.psa_weatherapp.repository

import com.jommaa.psa_weatherapp.data.repositoriesImp.WeatherRepositoryImp
import com.jommaa.weatherlib.WeatherApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.any


class WeatherRepositoryImpTest {


    private lateinit var weatherRepository: WeatherRepositoryImp
    private lateinit var weatherApi: WeatherApi

    @Before
    internal fun setUp() {

    }

    @ExperimentalCoroutinesApi
    @Test
    fun checkServiceCall() = runBlocking {
        weatherApi = mock()
        weatherRepository = WeatherRepositoryImp(weatherApi, any())
        //When
        weatherRepository.getWeatherDetails(0.0, 0.0, "")
        //then
        Mockito.verify(weatherApi, Mockito.times(1)).getWeatherDetails(any(), any(), any())
    }

}