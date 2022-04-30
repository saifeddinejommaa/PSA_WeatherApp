package com.jommaa.psa_weatherapp.domain.entities

data class WeathlySequence(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve: Float,
    val morn:Float) {
}