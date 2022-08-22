package com.example.mlchallenge.data.provider

import com.example.mlchallenge.data.model.ItemModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemsProvider @Inject constructor() {
        var items: ArrayList<ItemModel>? = arrayListOf()
        var selectedItem: ItemModel? = null
}