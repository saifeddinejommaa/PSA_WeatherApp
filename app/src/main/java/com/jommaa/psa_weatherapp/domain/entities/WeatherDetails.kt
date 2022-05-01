package com.jommaa.psa_weatherapp.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "weatherDetails")
data class WeatherDetails(

    @Ignore
    val lat: Double,
    @Ignore
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    @Ignore
    var current: Current?,
    @Ignore
    val minutely: List<Minutely?>?,
    @Ignore
    val hourly: List<Current?>?,
    @ColumnInfo(name = "townId")
    val townId: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int = 0

)

{
constructor(
             timezone: String,
             timezoneOffset: Int,
             townId: Int,
             id:Int = 0):this(0.0, 0.0, timezone, timezoneOffset, null, null, null, townId)
}