package com.example.cityapp

import android.app.Person

//TODO("I need to create a UseCase that contains Event, Culture,)


//TODO("CREATE A CLASS LIKE THIS")
//sealed class Resource<T>(val data: T? = null, val uiText: UiText? = null) {
//    class Success<T>(data: T?): Resource<T>(data)
//    class Error<T>(uiText: UiText, data: T? = null): Resource<T>(data, uiText)
//}
//
////Another way of doing UIState that isn't mutually exclusive
//data class UiState(
//    val isLoading: Boolean = false,
//    val error: Error? = null,
//    val items: List<Person> = listOf()
//){
//    sealed class Error{
//        object NetworkError : Error()
//        object InputTooShort : Error()
//        object InputEmpty : Error()
//    }
//}