package com.example.mlchallenge.domain.exception

class InternalServerErrorException(mensaje: String, val data: Any?): Exception(mensaje)