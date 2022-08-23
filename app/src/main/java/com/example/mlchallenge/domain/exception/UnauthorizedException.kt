package com.example.mlchallenge.domain.exception

class UnauthorizedException(mensaje: String, val data: Any?): Exception(mensaje)