package com.example.mlchallenge.data.network

import com.example.mlchallenge.data.Constants.SITE_ID
import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ItemService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getItems(itemSearched: String): Response<ResultModel> {
        return withContext(Dispatchers.IO){
            val response = apiClient.getItems(SITE_ID, itemSearched)
            response
        }
    }

    suspend fun getItemDetail(itemId: String): Response<ItemDetailModel> {
        return withContext(Dispatchers.IO){
            val response = apiClient.getItemDetail(itemId)
            response
        }
    }
}