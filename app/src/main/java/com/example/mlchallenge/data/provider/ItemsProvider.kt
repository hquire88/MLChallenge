package com.example.mlchallenge.data.provider

import com.example.mlchallenge.data.model.ItemDetailModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemsProvider @Inject constructor() {
        var items: ArrayList<ItemDetailModel>? = arrayListOf()
        var selectedItem: ItemDetailModel? = null
}