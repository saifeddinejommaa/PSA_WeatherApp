package com.jommaa.psa_weatherapp.observer

import java.util.*

class FragmentObserver : Observable() {

    override fun notifyObservers() {
        setChanged()
        super.notifyObservers()
    }
}