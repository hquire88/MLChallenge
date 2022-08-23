package com.example.mlchallenge.domain.util

import android.util.Log
import retrofit2.Response

fun <T> showCodeAndMessage(httpResponse: Response<T>){
     when(httpResponse.code()){
        HttpStatus.SUCCESS.code -> {
            HttpStatus.SUCCESS.showCodeAndMessage()
        }
        HttpStatus.UNAUTHORIZED.code -> {
            HttpStatus.UNAUTHORIZED.showCodeAndMessage()
        }
        HttpStatus.NOT_FOUND.code -> {
            HttpStatus.NOT_FOUND.showCodeAndMessage()
        }
        HttpStatus.INTERNAL_SERVER_ERROR.code -> {
            HttpStatus.INTERNAL_SERVER_ERROR.showCodeAndMessage()
        }
        else -> {
            Log.d("ELSE_HTTP_STATUS", "Codigo de peticion no contemplado: Code: ${httpResponse.code()} | Message: ${httpResponse.message()}")
        }
    }
}