package com.example.mlchallenge.data.network

import com.example.mlchallenge.data.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    // Items Services
    @GET("sites/{site_id}/search")
    suspend fun getItems(@Path("site_id") idSeries: String,
                         @Query("q") itemSearched: String): Response<ResultModel>
}