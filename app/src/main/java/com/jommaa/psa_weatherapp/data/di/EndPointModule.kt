package com.jommaa.psa_weatherapp.data.di



import com.jommaa.weatherlib.WeatherEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EndPointModule {

    @Provides
    @Singleton
    fun providesWeatherEndPointModule(retrofit: Retrofit): WeatherEndPoint {
        return retrofit.create(WeatherEndPoint::class.java)
    }
}