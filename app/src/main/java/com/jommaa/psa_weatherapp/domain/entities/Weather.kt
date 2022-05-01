package com.jommaa.psa_weatherapp.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "weatherId")
    val weatherId:Int=0,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "main")
    val main: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "icon")
    val icon: String,
    @ColumnInfo(name = "parentId")
    var parentId:Int) {
}