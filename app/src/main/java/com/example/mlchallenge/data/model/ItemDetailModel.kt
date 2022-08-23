package com.example.mlchallenge.data.model

data class ItemDetailModel(
    val id: String,
    val title: String,
    val seller_id: Int?,
    val price: Double,
    val currency_id: String,
    val available_quantity: Int,
    val buying_mode: String,
    val condition: String,
    val thumbnail: String,
    val pictures: ArrayList<PicturesModel>?,
    val installments: InstallmentsModel?,
    val shipping: ShippingModel
)