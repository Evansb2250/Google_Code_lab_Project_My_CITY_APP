package com.example.cityapp.data

import com.example.cityapp.R
import com.example.cityapp.model.CultureHeader
import com.example.cityapp.model.EventHeader
import com.example.cityapp.model.HistoryHeader
import com.example.cityapp.model.HomeScreenHeaders.CUlTURE
import com.example.cityapp.model.HomeScreenHeaders.EVENTS
import com.example.cityapp.model.HomeScreenHeaders.History
import com.example.cityapp.model.MedellinEvents

object DataSource {
    val listOfHeaders = listOf(
        EventHeader(EVENTS, R.drawable.my_project),
        HistoryHeader(History, R.drawable.filter_icon),
        CultureHeader(CUlTURE, R.drawable.catalog_icon),
    )

    val events = listOf(
        MedellinEvents(name = "Pa, Medallo", details = "Apart of the festival"),
        MedellinEvents(name = "Festival of the Flowers", details = "Apart of the festival"),
        MedellinEvents(name = "MindValley full day for\nConnection", details = "Apart of the festival"),
        MedellinEvents(name = "Soy Rebelde Tour", details = "Apart of the festival"),
        MedellinEvents(name = "Creados para Crear", details = "Apart of the festival")
    )

    val historyEvents = listOf(
        MedellinHistory("Platano", "Blah"),
        MedellinHistory("Bannan", "Blah"),
        MedellinHistory("Manzana", "Blah"),
        MedellinHistory("Plato", "Blah"),

    )

    val culturalItems = listOf(
        ColombianCulture("Dating"),
        ColombianCulture("Social Norms"),
        ColombianCulture("No Dar Papaya"),
        ColombianCulture("Metro"),
        ColombianCulture("Religious"),
    )
}