package com.example.mlchallenge.domain.exception

import android.util.Log
import com.example.mlchallenge.data.Constants
import com.example.mlchallenge.domain.util.showCodeAndMessage
import retrofit2.Response

object ExceptionHandler {

    @Throws(Exception::class)
    fun<T> verifyResponse(httpResponse: Response<T>): Response<T> {
        showCodeAndMessage(httpResponse)
        return when(httpResponse.code()){
            200 -> httpResponse
            401 -> throw UnauthorizedException("Unauthorized - 401", httpResponse)
            404 -> throw BadRequestException("Bad request - 404", httpResponse)
            500 -> throw InternalServerErrorException("Internal server error - 500", httpResponse)
            else -> throw UnknownException("Unknown exception", httpResponse)
        }
    }

    fun<T> verifyException(e: T): T{
        return when(e) {
            is UnauthorizedException -> {
                showExceptionMessage(e.message!!)
                e
            }
            is BadRequestException -> {
                showExceptionMessage(e.message!!)
                e
            }
            is InternalServerErrorException -> {
                showExceptionMessage(e.message!!)
                e
            }
            else -> {
                showExceptionMessage("Excepcion no contemplada: $e")
                e
            }
        }
    }

    private fun showExceptionMessage(message: String){
        Log.d(Constants.EXCEPTION_TAG, message)
    }

}