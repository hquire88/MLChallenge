package com.example.mlchallenge.domain.exception

class UnknownException(mensaje: String, val data: Any?): Exception(mensaje)