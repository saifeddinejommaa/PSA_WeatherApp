package com.jommaa.datacomponent.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jommaa.psa_weatherapp.domain.entities.Town

@Dao
interface TownDao {
    @Query("SELECT * FROM town")
    fun getAll(): LiveData<List<Town>>

    @Query("SELECT * FROM town WHERE id=:townId")
     fun loadById(townId: Int): Town

    @Query("SELECT count(*) from town")
    fun getTownsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert( vararg town: Town?)

    @Delete
     fun delete(town: Town)
}