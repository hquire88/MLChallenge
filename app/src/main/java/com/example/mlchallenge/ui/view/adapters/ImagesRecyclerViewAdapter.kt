package com.example.mlchallenge.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mlchallenge.R
import com.example.mlchallenge.data.model.PicturesModel
import com.squareup.picasso.Picasso

class ImagesRecyclerViewAdapter(private var imagesList: ArrayList<PicturesModel>?) :
    RecyclerView.Adapter<ImagesRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_image_recycler, parent, false)
        return ImagesRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (this.imagesList?.size!! > 0) {
            imagesList?.size!!
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: ImagesRecyclerViewHolder, position: Int) {
        holder.itemImage
        Picasso.get().load(imagesList?.get(position)?.url).into(holder.itemImage)
    }
}