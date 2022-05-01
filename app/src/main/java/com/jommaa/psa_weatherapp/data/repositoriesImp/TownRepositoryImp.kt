package com.jommaa.psa_weatherapp.data.repositoriesImp

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.jommaa.psa_weatherapp.data.mapper.TownMapper
import com.jommaa.psa_weatherappapplication.domain.Results.DataResult
import com.jommaa.psa_weatherappapplication.domain.repository.ITownRepository
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.datacomponent.db.datasource.TownDataSource
import java.lang.Exception
import javax.inject.Inject

class TownRepositoryImp @Inject constructor(private val townMapper: TownMapper, private val dataSource: TownDataSource
) : ITownRepository {


    override suspend  fun insertTown(town: Town) {
        dataSource.insertTown(town)
     }  

    override  fun   getAllTowns(): LiveData<DataResult> {
        try {

            val data: LiveData<List<Town>> = dataSource.getAllTowns()
               return mappingData(data)

        } catch (ex: Exception) {
            return liveData {
                DataResult.Failure(ex)
            }
        }
    }

    private fun mappingData(baseData:LiveData<List<Town>>):LiveData<DataResult>{
        return Transformations.map(baseData)
        {  list ->
            fromTownsResponsesToDataResult(list)
        }
    }

    private fun fromTownsResponsesToDataResult(towns:List<Town>):DataResult{
        return DataResult.TownsListResult(towns)
    }


    override suspend fun getTownById(id: Int)= liveData<DataResult> {
        emit(DataResult.Loading)
        try {
            emit(DataResult.TownResult(dataSource.getTownById(id)))
        }
        catch (exception: Exception){
            emit(DataResult.Failure(exception))
        }
    }

    override suspend fun getTownsCount(): Int {
        return dataSource.getTownsCount()
    }


}