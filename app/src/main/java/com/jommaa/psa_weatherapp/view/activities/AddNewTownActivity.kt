package com.jommaa.psa_weatherapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jommaa.psa_weatherapp.R
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.viewmodel.AddNewTownViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_new_town.*

@AndroidEntryPoint
class AddNewTownActivity  : BaseActivity() {


    private val vm: AddNewTownViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_town)
        vm.setNavigationHandler((this))

        val resultObserver=Observer<Town>{ town ->
            city_name_result_content_txt.text=town.name
            city_lat_result_content_txt.text = town.lat.toString()
            city_lat_result_content_txt.text = town.lon.toString()
        }

        vm.result.observe(this,resultObserver)

        addNewTownBtn.setOnClickListener {

            vm.addNewTown()
        }

        findTownBtn.setOnClickListener {
            vm.findTown(town_name_txt.text.toString())
        }


    }




}