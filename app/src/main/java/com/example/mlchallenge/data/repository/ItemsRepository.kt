package com.example.mlchallenge.data.repository

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.network.ItemService
import com.example.mlchallenge.data.provider.ItemsProvider
import com.example.mlchallenge.domain.exception.ExceptionHandler.verifyResponse
import retrofit2.Response
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val api : ItemService,
                                          private val itemsProvider : ItemsProvider
){

    suspend fun getItems(itemSearched: String): Response<ResultModel> {
        val response = api.getItems(itemSearched)
        itemsProvider.items = response.body()!!.results
        return verifyResponse(response)
    }

    suspend fun getSelectedItem(itemId: String): Response<ItemDetailModel>{
        val response = api.getItemDetail(itemId)
        itemsProvider.selectedItem = response.body()
        return verifyResponse(response)
    }
}