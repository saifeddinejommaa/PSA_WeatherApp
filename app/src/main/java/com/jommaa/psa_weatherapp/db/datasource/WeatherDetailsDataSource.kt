package com.jommaa.psa_weatherapp.db.datasource

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.jommaa.psa_weatherapp.db.AppDatabase
import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.psa_weatherapp.domain.entities.Weather
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.Exception
import javax.inject.Inject

class WeatherDetailsDataSource @Inject constructor(@ApplicationContext val context:android.content.Context) {

    val dataBase = AppDatabase.invoke(context)

    suspend fun insertWeatherDetails(weatherDetails: WeatherDetails) {
        try {
            val weatherDetailsId = dataBase.WeatherDetailsDao().insert(weatherDetails)
            weatherDetails.hourly?.let {
                for (current:Current? in it){
                    current?.parentId = weatherDetailsId.toInt()
                   val currentId = dataBase.CurrentDAO().insert(current)
                    current?.weather?.let{
                        for(weather:Weather in it){
                            weather.parentId = currentId.toInt()
                            dataBase.WeatherDAO().insert(weather)
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            ex.message?.let { Log.e("Exception", it) }
             Log.e("Exception", ex.stackTrace.toString())
            Toast.makeText(context, "Erreur", Toast.LENGTH_LONG).show()
        }
    }

    fun getTownWeatherDetails(townId: Int) : LiveData<WeatherDetails> {
        var weatherDetails = dataBase.WeatherDetailsDao().loadById(townId)
        weatherDetails.value?.let {
            weatherDetails.value?.current = dataBase.CurrentDAO().loadById(it.id)
            weatherDetails.value?.current?.let {
                it.weather = dataBase.WeatherDAO().loadById(it.parentId)
            }
        }

       return weatherDetails
    }
}

