package com.example.mlchallenge.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mlchallenge.R
import com.example.mlchallenge.core.OnItemClickListener
import com.example.mlchallenge.data.model.ItemModel
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class RecyclerViewAdapter(private var itemsList: ArrayList<ItemModel>?) :
    RecyclerView.Adapter<GenericRecyclerViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return GenericRecyclerViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return if (this.itemsList?.size!! > 0) {
            itemsList?.size!!
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: GenericRecyclerViewHolder, position: Int) {
        holder.itemValue!!.text =  itemsList?.get(position)?.currency_id + " $" + itemsList?.get(position)?.price
        holder.itemName!!.text =  itemsList?.get(position)?.title
        Picasso.get().load(itemsList?.get(position)?.thumbnail).into(holder.itemImage)
    }
}