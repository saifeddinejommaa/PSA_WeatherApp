package com.jommaa.psa_weatherapp

import android.os.Bundle

interface INavigationHandler {

    fun showNextActivity(clazz: Class<*>, bundle: Bundle?)

    fun finishActivity()
}