package com.example.mlchallenge.domain.usecase

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.repository.ItemsRepository
import com.example.mlchallenge.domain.exception.ExceptionHandler
import com.example.mlchallenge.domain.util.Resource
import javax.inject.Inject

class GetSelectedItemUseCase @Inject constructor(
    private val repository : ItemsRepository
) {
    suspend fun responseUseCase(id: String): Resource<ItemDetailModel?> {
        return try {
            val response = repository.getSelectedItem(id)
            Resource.Success(response.body())
        } catch (e: Exception){
            val exception = ExceptionHandler.verifyException(e)
            Resource.Error(null, exception)
        }
    }
}