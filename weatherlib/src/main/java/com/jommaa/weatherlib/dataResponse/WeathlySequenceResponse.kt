package com.jommaa.weatherlib.dataResponse

data class WeathlySequenceResponse(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve: Float,
    val morn:Float) {
}