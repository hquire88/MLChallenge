package com.example.mlchallenge.domain.util

import android.util.Log

enum class HttpStatus(val code: Int, private val message: String) {
    SUCCESS(200, "Peticion exitosa"),
    UNAUTHORIZED(401, "Peticion fallida, sin autorizacion, revisar token"),
    NOT_FOUND(404, "Peticion fallida, respuesta no encontrada en el servidor"),
    INTERNAL_SERVER_ERROR(500, "Peticion fallida, error en el servidor");

    fun showCodeAndMessage(){
        Log.d("HTTP_STATUS", " Codigo de la peticion: Code: $code || Message: $message")
    }

}