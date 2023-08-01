package com.example.cityapp.repo

import com.example.cityapp.data.DataSource
import com.example.cityapp.domain.MedellinEvents

interface EventRepository{
    fun getEvents(): List<MedellinEvents>
}


class EventRepositoryImpl : EventRepository{
    override fun getEvents(): List<MedellinEvents>{
        return DataSource.events
    }
}