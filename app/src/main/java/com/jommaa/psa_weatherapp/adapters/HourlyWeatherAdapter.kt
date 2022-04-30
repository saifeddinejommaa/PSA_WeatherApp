package com.jommaa.psa_weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.psa_weatherapp.R
import com.jommaa.psa_weatherapp.utils.WeatherUtilities

class HourlyWeatherAdapter(private val hourlyWeatherList: List<Current?>?) : RecyclerView.Adapter<HourlyWeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourly_weather_item, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun getItemCount(): Int {
         hourlyWeatherList?.let{
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val current = hourlyWeatherList?.get(position)

        current?.let{
            holder.weatherHour.text =WeatherUtilities.getHourFromMimeStamp(current.dt).toString()+":00"
            holder.weatherDegree.text = current.temp.toInt().toString()+"°"
            it.weather?.let {
            holder.image.setImageResource(WeatherUtilities.getWeatherIcon(current?.weather!![0].icon))
            }
        }

    }

    inner class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var weatherHour: TextView = view.findViewById(R.id.hour_txt)
        var image: ImageView = view.findViewById(R.id.weather_image)
        var weatherDegree: TextView = view.findViewById(R.id.degree_txt)
    }
}