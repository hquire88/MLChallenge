package com.example.mlchallenge.ui.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mlchallenge.R
import com.example.mlchallenge.core.OnItemClickListener

class GenericRecyclerViewHolder(view: View, listener: OnItemClickListener): RecyclerView.ViewHolder(view) {
    var itemName: TextView? = view.findViewById(R.id.item_title)
    var itemValue: TextView? = view.findViewById(R.id.price_value)
    var itemImage: ImageView? = view.findViewById(R.id.item_thumb)

    init {
        view.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}