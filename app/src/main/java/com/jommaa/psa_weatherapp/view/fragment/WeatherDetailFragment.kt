package com.jommaa.psa_weatherapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.jommaa.psa_weatherapp.domain.entities.Current
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.domain.entities.WeatherDetails
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.psa_weatherapp.R
import com.jommaa.psa_weatherapp.adapters.HourlyWeatherAdapter
import com.jommaa.psa_weatherapp.utils.WeatherUtilities
import com.jommaa.psa_weatherapp.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class WeatherDetailFragment(val town: Town?): Fragment() {


    private val vm: DetailsViewModel by viewModels()

    lateinit var hourlyWeatherListAdapter: HourlyWeatherAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    private fun bindHourlyWeatherList(hourlyList:List<Current?>?){
        hourlyList?.let {
            val mLayoutManager = LinearLayoutManager(context)
            hourlyWeatherListAdapter = HourlyWeatherAdapter(hourlyList)
            mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            hourly_view.layoutManager = mLayoutManager
            hourly_view.itemAnimator = DefaultItemAnimator()
            hourly_view.adapter = hourlyWeatherListAdapter
            hourlyWeatherListAdapter.notifyDataSetChanged()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        vm.details?.observe(viewLifecycleOwner, Observer<DataResult> {result ->
            when(result){
                is DataResult.Loading -> {
                }
                is DataResult.WeatherDetailsResult -> {
                    result.details?.let {
                        bindWeatherDetails(it)
                        bindHourlyWeatherList(it.hourly)
                    }

                }
                is DataResult.Failure -> {

                }
            }

        })

    }

    private fun bindWeatherDetails(details: WeatherDetails){
        if(details.hourly !=null){
            details.hourly[0]?.let { bindCurrentWeather (it) }
        }

    }

    private fun bindCurrentWeather (current: Current){
        temp_txt.text= Math.round(current.temp).toString()+"°"
        current.weather?.let{
            currentweather_image.setImageResource(WeatherUtilities.getWeatherIcon(current.weather[0].icon))
        }
    }
    private fun bind(){
     town?.let {
         townName_txt.setText(it.name)
         vm.getWeatherDetail(town)
     }
 }
}