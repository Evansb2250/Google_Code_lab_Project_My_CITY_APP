package com.example.cityapp.application

import android.content.Context

//need to create an interface
interface ApplicationContainer{

}

class DefaultApplicationContainer(val context: Context): ApplicationContainer{

}