package com.example.mlchallenge.domain.usecase

import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.repository.ItemsRepository
import com.example.mlchallenge.domain.exception.ExceptionHandler
import com.example.mlchallenge.domain.util.Resource
import javax.inject.Inject

class GetItemSearchedUseCase @Inject constructor(
    private val repository : ItemsRepository
) {
    suspend fun responseUseCase(itemSearched: String): Resource<ResultModel?> {
        return try {
            val response = repository.getItems(itemSearched)
            Resource.Success(response.body())
        } catch (e: Exception){
            val exception = ExceptionHandler.verifyException(e)
            Resource.Error(null, exception)
        }
    }
}