package com.example.mlchallenge

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.model.ResultModel
import com.example.mlchallenge.data.model.ShippingModel
import com.example.mlchallenge.data.repository.ItemsRepository
import com.example.mlchallenge.domain.usecase.GetItemSearchedUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetItemsSearchedUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: ItemsRepository

    lateinit var getItemSearchedUseCase: GetItemSearchedUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getItemSearchedUseCase = GetItemSearchedUseCase(repository)
    }

    @Test
    fun whenRunAPIReceiveItemsSearched() = runBlocking {
        //Given
        val items = ItemDetailModel(
            "123",
            "Memoria Ram",
            null,
            589.20,
            "ARG",
            2,
            "BUY_NOW",
            "new",
            "www.example.com",
            null,
            null,
            ShippingModel(true)
        )

        val result = ResultModel(arrayListOf(items, items))
        coEvery { repository.getItems("123") } returns result

        //When
        val response = getItemSearchedUseCase("123")

        //Then
        coVerify(exactly = 1) { repository.getItems("123") }
        assert(result == response)
    }
}