package com.example.mlchallenge.data.repository

import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.network.ItemService
import com.example.mlchallenge.data.provider.ItemsProvider
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val api : ItemService,
                                          private val itemsProvider : ItemsProvider
){

    suspend fun getItems(itemSearched: String): ResultModel?{
        val response = api.getItems(itemSearched)
        itemsProvider.items = response?.results
        return response
    }
}