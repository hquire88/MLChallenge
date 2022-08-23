package com.example.mlchallenge.ui.view.adapters

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mlchallenge.R

class ImagesRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var itemImage: ImageView? = view.findViewById(R.id.item_image)

    init {

    }
}