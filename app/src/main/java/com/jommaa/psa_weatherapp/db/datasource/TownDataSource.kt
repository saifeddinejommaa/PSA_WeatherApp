package com.jommaa.datacomponent.db.datasource


import android.widget.Toast
import androidx.lifecycle.LiveData
import com.jommaa.psa_weatherapp.domain.entities.Town
import com.jommaa.psa_weatherapp.db.AppDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.Exception
import javax.inject.Inject

class  TownDataSource @Inject constructor( @ApplicationContext val context:android.content.Context)  {

    val dataBase=AppDatabase.invoke(context)

     suspend fun  insertTown(town: Town){
         try {
             return dataBase.TownDao().insert(town)
         }
         catch (ex: Exception){
             Toast.makeText(context,"Erreur",Toast.LENGTH_LONG).show()
         }

    }

    fun getAllTowns()=   dataBase.TownDao().getAll()


    suspend fun getTownById(id : Int):Town{
        return  dataBase.TownDao().loadById(id)
    }

    suspend fun getTownsCount() : Int {
        return dataBase.TownDao().getTownsCount()
    }




}