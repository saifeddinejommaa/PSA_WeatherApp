package com.jommaa.psa_weatherapp.domain.entities

data class Weather(val id: Int,
                   val main: String,
                   val description: String,
                   val icon: String) {
}