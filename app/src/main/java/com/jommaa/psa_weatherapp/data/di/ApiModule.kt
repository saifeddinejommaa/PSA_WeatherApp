package com.jommaa.psa_weatherapp.data.di



import com.jommaa.weatherlib.WeatherApi
import com.jommaa.weatherlib.WeatherEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Singleton
    @Provides
    fun providesWeatherApi(weatherEndPoint: WeatherEndPoint): WeatherApi{
        return WeatherApi(weatherEndPoint)
    }
}

