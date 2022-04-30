package com.jommaa.psa_weatherapp.utils

import com.jommaa.psa_weatherapp.R
import java.util.*

class WeatherUtilities {

    companion object {

        fun getWeatherIcon(iconName: String?): Int{
            when(iconName){
                "01d" ->{
                    return R.mipmap.sunny1
                }
                "02d" ->{
                    return R.mipmap.sunny2
                }
                "01n" ->{
                    return R.mipmap.night1
                }
                "02n" ->{
                    return R.mipmap.night2
                }
                "03d" ->{
                    return R.mipmap.couverage1
                }
                "03n" ->{
                    return R.mipmap.couverage2
                }

                "09n" ->{
                    return R.mipmap.rain2
                }
                "09d" ->{
                     return R.mipmap.rain1
                }
                "10n" ->{
                    return R.mipmap.night3
                }
                "10d" ->{
                    return R.mipmap.sunny3
                }
                "11d" ->{
                     return R.mipmap.flash1
                }
                "11n" ->{
                     return R.mipmap.flash2
                }
                "13d" ->{
                     return R.mipmap.snow1
                }
                "13n" ->{
                     return R.mipmap.snow2
                }
                "50d" ->{
                     return R.mipmap.wind1
                }
                "50n" ->{
                     return R.mipmap.wind2
                }
            }
            return R.mipmap.sunny1
        }

        fun getHourFromMimeStamp(timestamp: Long):Int{
            val date = Date(timestamp*1000)
            val cal = Calendar.getInstance()
            cal.time = date
            val hours = cal.get(Calendar.HOUR_OF_DAY)
            return hours

        }

        fun compareDateWithCurrentDate(timestamp:Long):Long{
            val currentDate = Date(System.currentTimeMillis())
            val date = Date(timestamp*1000)
            val diff = date.time - currentDate.time
            return diff/1000
        }
    }
}