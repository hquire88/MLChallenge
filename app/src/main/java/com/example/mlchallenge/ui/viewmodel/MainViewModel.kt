package com.example.mlchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.domain.GetItemSearchedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getItemsUseCase: GetItemSearchedUseCase): ViewModel() {

    val resultItemsModel = MutableLiveData<ResultModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCall(itemSearched: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getItemsUseCase(itemSearched)

            if (result != null){
                resultItemsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}