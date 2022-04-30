package com.jommaa.psa_weatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class  PSAWeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}