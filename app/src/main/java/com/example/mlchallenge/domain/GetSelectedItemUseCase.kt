package com.example.mlchallenge.domain

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.repository.ItemsRepository
import javax.inject.Inject

class GetSelectedItemUseCase @Inject constructor(
    private val repository : ItemsRepository
) {
    suspend operator fun invoke(id: String): ItemDetailModel? = repository.getSelectedItem(id)
}