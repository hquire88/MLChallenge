package com.example.mlchallenge.data.model

data class ItemModel(
    val id: String,
    val title: String,
    val seller: SellerModel,
    val price: Double,
    val currency_id: String,
    val available_quantity: Int,
    val buying_mode: String,
    val condition: String,
    val thumbnail: String,
    val installments: InstallmentsModel,
    val address: AddressDataModel,
    val shipping: ShippingModel
)