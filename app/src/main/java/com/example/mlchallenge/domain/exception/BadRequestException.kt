package com.example.mlchallenge.domain.exception

class BadRequestException(mensaje: String, val data: Any?): Exception(mensaje)