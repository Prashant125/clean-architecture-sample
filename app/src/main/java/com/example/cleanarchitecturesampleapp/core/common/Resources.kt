package com.example.cleanarchitecturesampleapp.core.common

sealed class Resources <T>(val data: T? = null,val message: String? = null) {
    class Success <T>(apiData: T): Resources <T>(data = apiData)
    class Error <T>(errorMessage: String) : Resources <T>(message = errorMessage)
    class Loading<T> : Resources<T>()
}