package com.example.mlchallenge.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mlchallenge.data.model.PicturesModel
import com.example.mlchallenge.databinding.ActivityDetailBinding
import com.example.mlchallenge.ui.view.adapters.ImagesRecyclerViewAdapter
import com.example.mlchallenge.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private var position: Int = 0
    private var id: String = ""

    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var imagesRVAdapter: ImagesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        position = intent.getIntExtra("position",0)
        id = intent.getStringExtra("id")!!

        detailViewModel.onCreate(id)

        detailViewModel.resultSelectedItemModel.observe(this) {
            if (it != null) {
                detailBinding.itemTitle.text = it.title
                detailBinding.itemCondition.text = it.condition
                detailBinding.itemPrice.text = it.currency_id + " " + it.price.toString()
                detailBinding.freeShipping.isVisible = it.shipping.free_shipping

                if (it.pictures != null){
                    setImagesRV(it.pictures)
                }
            }
        }
    }

    private fun setImagesRV(imagesList: ArrayList<PicturesModel>){
        val lLayout = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
        detailBinding.imagesRv.setHasFixedSize(true)
        detailBinding.imagesRv.layoutManager = lLayout

        imagesRVAdapter = ImagesRecyclerViewAdapter(imagesList)
        detailBinding.imagesRv.adapter = imagesRVAdapter
    }
}