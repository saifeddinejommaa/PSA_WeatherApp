package com.jommaa.psa_weatherapp.domain.entities

import com.google.gson.annotations.SerializedName


data class Rain(
    @SerializedName("1h")
    val oneOur: Float) {
}