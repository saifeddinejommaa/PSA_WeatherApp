package com.jommaa.psa_weatherapp.data.repositoriesImp

import android.util.Log
import androidx.lifecycle.*
import com.jommaa.psa_weatherapp.data.mapper.WeatherDetailsMapper
import com.jommaa.psa_weatherapp.db.datasource.WeatherDetailsDataSource
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.psa_weatherapp.domain.repository.IWeatherRepository
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.weatherlib.WeatherApi
import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImp  @Inject  constructor(
    private val weatherApi: WeatherApi, private val weatherDetailsMapper : WeatherDetailsMapper, private val weatherDetailsDataSource:WeatherDetailsDataSource
) :IWeatherRepository  {

    override suspend fun getWeatherDetails(townId:Int,lat: Double, lng: Double, units: String):  DataResult  {

        try {
             val weatherDetailsResponse = weatherApi.getWeatherDetails(lat, lng, units)
             val weatherDetails = fromWeatherDetailsResponseToWeatherDetails(townId,weatherDetailsResponse)
            //insertWeatherDetails(weatherDetails)
             return fromTownsResponsesToDataResult(weatherDetails)
        }
        catch (exception: Exception){
           return DataResult.Failure(exception)
        }
    }

    override suspend  fun insertWeatherDetails(weatherDetails:WeatherDetails){
        try {
            weatherDetailsDataSource.insertWeatherDetails(weatherDetails)
        }
        catch (ex:Exception){
            Log.e("WeatherRepository","erreur putting weather details")
        }
    }

    override  fun getWeatherDetailsFromDB(townId: Int): LiveData<DataResult> {
        try{
        val data: LiveData<WeatherDetails> = weatherDetailsDataSource.getTownWeatherDetails(townId)
        return mappingData(data)
        }
        catch(ex:Exception){
            Log.e("WeatherRepository","erreur getting weather details")
            return liveData { DataResult.Failure(ex)}
        }

    }
    private fun mappingData(baseData:LiveData<WeatherDetails>):LiveData<DataResult>{
        return Transformations.map(baseData)
        {  detail ->
            fromTownsResponsesToDataResult(detail)
        }
    }
    private fun fromWeatherDetailsResponseToWeatherDetails(townId:Int,responses: WeatherDetailsResponse): WeatherDetails{
        return weatherDetailsMapper.toWeatherDetails(townId,responses)
    }
    private fun fromTownsResponsesToDataResult(weatherDetails: WeatherDetails):DataResult{
        return DataResult.WeatherDetailsResult(weatherDetails)
    }


}