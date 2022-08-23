package com.example.mlchallenge

import com.example.mlchallenge.data.model.ItemDetailModel
import com.example.mlchallenge.data.model.ShippingModel
import com.example.mlchallenge.data.repository.ItemsRepository
import com.example.mlchallenge.domain.usecase.GetSelectedItemUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetSelectedItemUseCaseTest{
    @RelaxedMockK
    private lateinit var repository : ItemsRepository

    lateinit var getSelectedItemUseCase: GetSelectedItemUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getSelectedItemUseCase = GetSelectedItemUseCase(repository)
    }

    @Test
    fun whenRunAPIRecieveASeries() = runBlocking {
        //Given
        val item = ItemDetailModel(
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

        coEvery { repository.getSelectedItem("456") } returns item

        //When
        val response = getSelectedItemUseCase("456")

        //Then
        coVerify(exactly = 1) { repository.getSelectedItem("456") }
        assert(item == response)
    }
}