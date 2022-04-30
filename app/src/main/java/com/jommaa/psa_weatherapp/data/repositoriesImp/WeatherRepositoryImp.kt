package com.jommaa.psa_weatherapp.data.repositoriesImp

import androidx.lifecycle.*
import com.jommaa.psa_weatherapp.data.mapper.WeatherDetailsMapper
import com.jommaa.psa_weatherapp.domain.repository.IWeatherRepository
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.weatherlib.WeatherApi
import com.jommaa.weatherlib.dataResponse.WeatherDetailsResponse
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImp  @Inject  constructor(
    private val weatherApi: WeatherApi, private val weatherDetailsMapper : WeatherDetailsMapper
) :IWeatherRepository  {

    override suspend fun getWeatherDetails(lat: Double, lng: Double, units: String):  DataResult  {

        try {
            val weatherDetailsResponse = weatherApi.getWeatherDetails(lat, lng, units)
            return fromTownsResponsesToDataResult(weatherDetailsResponse)
        }
        catch (exception: Exception){
           return DataResult.Failure(exception)
        }
    }

    private fun mappingData(baseData: WeatherDetailsResponse):LiveData<DataResult>{
        var dataResult: MutableLiveData<DataResult> = MutableLiveData()
        dataResult.postValue(fromTownsResponsesToDataResult(baseData))
        return dataResult
    }

    private fun fromTownsResponsesToDataResult(responses: WeatherDetailsResponse):DataResult{
        val weatherDetails = weatherDetailsMapper.toWeatherDetails(responses)
        return DataResult.WeatherDetailsResult(weatherDetails)
    }


}