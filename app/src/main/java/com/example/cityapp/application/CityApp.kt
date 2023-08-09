package com.example.cityapp.application

import android.app.Application

class CityApp: Application() {
    lateinit var container: ApplicationContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer(this)
    }
}