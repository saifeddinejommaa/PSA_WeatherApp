package com.jommaa.psa_weatherapp.db.dao

import androidx.room.*
import com.jommaa.psa_weatherapp.domain.entities.Current

@Dao
interface CurrentDAO {

    @Query("SELECT * FROM current WHERE parentId=:prentId")
    fun loadById(prentId: Int): Current?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(current: Current?):Long

    @Delete
    fun delete(current: Current)
}