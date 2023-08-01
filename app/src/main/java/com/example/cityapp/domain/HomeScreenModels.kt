package com.example.cityapp.domain

import androidx.annotation.DrawableRes

interface HomeScreenUIElements {
    val title: HomeScreenHeaders
    @get:DrawableRes
    val resourceId: Int
}



enum class HomeScreenHeaders(title: String) {
    Home("Home"),
    EVENTS("Events"),
    History("History"),
    CUlTURE("Culture")
}

data class EventHeader(override val title: HomeScreenHeaders, @DrawableRes override val resourceId: Int):
    HomeScreenUIElements
data class HistoryHeader(override val title: HomeScreenHeaders, @DrawableRes override val resourceId: Int):
    HomeScreenUIElements
data class CultureHeader(override val title: HomeScreenHeaders, @DrawableRes override val resourceId: Int):
    HomeScreenUIElements

data class HomeScreenUIState(val title: HomeScreenHeaders, val headers:List<HomeScreenUIElements>)

// val eventHeader: EventHeader, val historyHeader: HistoryHeader, val cultureHeader: CultureHeader