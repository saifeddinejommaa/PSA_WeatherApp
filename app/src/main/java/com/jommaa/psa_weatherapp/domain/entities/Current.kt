package com.jommaa.psa_weatherapp.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "current")
data class Current(
    @ColumnInfo(name = "dt")
    override val dt : Long,
    @ColumnInfo(name = "sunrise")
    override val sunrise :Long,
    @ColumnInfo(name = "sunset")
    override val sunset : Long,
    @ColumnInfo(name = "pressure")
    override val pressure: Int,
    @ColumnInfo(name = "humidity")
    override val humidity: Int,
    @ColumnInfo(name = "dewPoint")
    @SerializedName("dew_point")
    override val dewPoint: Float,
    @ColumnInfo(name = "uvi")
    override val uvi: Float,
    @ColumnInfo(name = "clouds")
    override val clouds: Int,
    @ColumnInfo(name = "windSpeed")
    @SerializedName("wind_speed")
    override val windSpeed: Float,
    @ColumnInfo(name = "winDeg")
    @SerializedName("wind_deg")
    override val winDeg: Int,
    @Ignore
    @SerializedName("weather")
    override var weather: List<Weather>?,
    @ColumnInfo(name = "temp")
    val temp : Float,
    @ColumnInfo(name = "feelLike")
    @SerializedName("feels_like")
    val feelLike : Float,
    @ColumnInfo(name = "visibility")
    val visibility: Int,
    @ColumnInfo(name = "parentId")
    var parentId: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int = 0
) : WeatherStatus(dt, sunrise,sunset,pressure,humidity,dewPoint,uvi,clouds,windSpeed,winDeg,weather) {
    constructor( dt : Long,sunrise :Long, sunset : Long, pressure: Int, humidity: Int,dewPoint: Float, uvi: Float, clouds: Int, windSpeed: Float,winDeg: Int,temp : Float,
                  feelLike : Float,visibility: Int,parentId: Int):this(dt,sunrise  , sunset , pressure, humidity,dewPoint, uvi, clouds, windSpeed,winDeg,null,temp,
        feelLike ,visibility,parentId)
}