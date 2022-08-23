package com.example.mlchallenge.domain.util

sealed class Resource<T>(val data: T? = null,
                         val excepcion: Exception? = null) {

    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(data: T? = null, exception: Exception): Resource<T>(data, exception)
    class Loading<T>: Resource<T>()

}