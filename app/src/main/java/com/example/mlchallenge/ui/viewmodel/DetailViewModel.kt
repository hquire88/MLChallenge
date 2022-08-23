package com.example.mlchallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.domain.usecase.GetSelectedItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSelectedItemUseCase: GetSelectedItemUseCase
): ViewModel() {

    val resultSelectedItemModel = MutableLiveData<ItemDetailModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSelectedItemUseCase.responseUseCase(id)

            if (result != null){
                resultSelectedItemModel.postValue(result.data)
                isLoading.postValue(false)
            }
        }
    }
}