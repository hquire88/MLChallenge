package com.example.mlchallenge.domain

import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.repository.ItemsRepository
import javax.inject.Inject

class GetItemSearchedUseCase @Inject constructor(
    private val repository : ItemsRepository
) {

    suspend operator fun invoke(itemSearched: String): ResultModel? = repository.getItems(itemSearched)
}