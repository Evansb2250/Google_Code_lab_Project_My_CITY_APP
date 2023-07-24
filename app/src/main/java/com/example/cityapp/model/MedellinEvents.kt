package com.example.cityapp.model

interface ListViewItems {
    val name: String
    val details: String
}

data class MedellinEvents(override val name: String, val location: String = "unKnown", override val details: String): ListViewItems