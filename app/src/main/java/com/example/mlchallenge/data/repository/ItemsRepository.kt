package com.example.mlchallenge.data.repository

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.network.ItemService
import com.example.mlchallenge.data.provider.ItemsProvider
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class ItemsRepository @Inject constructor(private val api : ItemService,
                                          private val itemsProvider : ItemsProvider
){

    suspend fun getItems(itemSearched: String): ResultModel?{
        val response = api.getItems(itemSearched)
        itemsProvider.items = response?.results
        return response
    }

    suspend fun getSelectedItem(itemId: String): ItemDetailModel?{
        val response = api.getItemDetail(itemId)
        if (response != null){
            itemsProvider.selectedItem = response
        }

        return response
    }
}