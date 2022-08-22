package com.example.mlchallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mlchallenge.core.OnItemClickListener
import com.example.mlchallenge.databinding.ActivityMainBinding
import com.example.mlchallenge.ui.view.adapters.RecyclerViewAdapter
import com.example.mlchallenge.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var itemsRVAdapter: RecyclerViewAdapter

    private var itemSearched: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setSearchListeners()
        setButtonListener()

        val lLayout = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        activityMainBinding.itemsRv.setHasFixedSize(true)
        activityMainBinding.itemsRv.layoutManager = lLayout

        initItemSearchedObserver()
    }

    private fun initItemSearchedObserver() {
        mainViewModel.resultItemsModel.observe(this, Observer {
            // set recyclerView con los datos obtenidos
            itemsRVAdapter = RecyclerViewAdapter(it?.results)
            activityMainBinding.itemsRv.adapter = itemsRVAdapter
            itemsRVAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(position: Int) {
//                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                    intent.putExtra("position", position)
//                    intent.putExtra("id", it.data.results[position].id)
//                    intent.putExtra("itemType", "series")
//
//                    startActivity(intent)

                    Toast.makeText(this@MainActivity, "Has cliqueado en Pelicula: ${position + 1}", Toast.LENGTH_SHORT).show()
                }
            })
        })
    }

    private fun setButtonListener() {
        activityMainBinding.searchButton.setOnClickListener {
            mainViewModel.onCall(itemSearched)
        }
    }

    private fun setSearchListeners() {
        activityMainBinding.searchItem.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                itemSearched = newText
                activityMainBinding.searchedItemText.text = itemSearched.uppercase(Locale.ROOT)
                activityMainBinding.searchButton.isEnabled = newText.length >= 3
                return true
            }
        })
    }
}