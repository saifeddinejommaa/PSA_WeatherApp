package com.jommaa.psa_weatherapp.domain.usecases

import androidx.lifecycle.LiveData
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.psa_weatherappapplication.domain.repository.ITownRepository
import javax.inject.Inject

class TownUseCases @Inject  constructor(val repo : ITownRepository) {

    fun getTownsList(): LiveData<DataResult> {
        return repo.getAllTowns()
    }

     suspend fun addNewTown(town: Town){
        repo.insertTown(town =town )
    }
}