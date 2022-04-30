package com.jommaa.psa_weatherapp.data.mapper

import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.weatherlib.dataResponse.TownResponse
import javax.inject.Inject

class TownMapper  @Inject constructor(){
    fun toTown(townResp :TownResponse): Town{
        return Town(townResp.name,townResp.lat,townResp.lon,townResp.id)
    }

    fun toTownResponse(town: Town): TownResponse {

        return  TownResponse(town.name,town.lat,town.lon)
    }

}