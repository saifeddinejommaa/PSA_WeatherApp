package com.jommaa.psa_weatherapp.data.mapper


import com.jommaa.psa_weatherapp.domain.entities.Minutely
import com.jommaa.weatherlib.dataResponse.MinutelyResponse
import javax.inject.Inject

open class MinutelyMapper @Inject  constructor() {

    open fun toMinutely(resp:MinutelyResponse?): Minutely?{
        resp?.let { return Minutely(resp.dt,resp.precipitation)  }
        return null
    }

}