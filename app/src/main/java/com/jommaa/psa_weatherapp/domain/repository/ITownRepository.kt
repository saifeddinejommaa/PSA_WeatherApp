package com.jommaa.psa_weatherappapplication.domain.repository


import androidx.lifecycle.LiveData
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.psa_weatherapp.domain.entities.Town

interface ITownRepository {

    suspend fun insertTown(town: Town)

    fun  getAllTowns() : LiveData<DataResult>

    suspend fun getTownById(id:Int): LiveData<DataResult>

    suspend fun getTownsCount(): Int
}