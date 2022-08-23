package com.example.marvelchallenger.domain

import com.example.marvelchallenger.data.models.*
import com.example.marvelchallenger.data.repositories.SeriesRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetSeriesUseCaseTest{

    @RelaxedMockK
    private lateinit var repository : SeriesRepository

    lateinit var getSeriesUseCase: GetSeriesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getSeriesUseCase = GetSeriesUseCase(repository)
    }

    @Test
    fun whenRunAPIRecieveASeries() = runBlocking {
        //Given
        val series: SeriesModel = SeriesModel(123, "Spiderman", "Hombre Arana", ThumbnailModel("www.imagen.com", ".jpg"), "www.resource.com")
        val data: DataModel<SeriesModel> = DataModel(1500,20, arrayListOf(series, series))
        val result: ResultModel<SeriesModel> = ResultModel<SeriesModel>(200, "Ok", data)
        coEvery { repository.getAllSeries() } returns result

        //When
        val response = getSeriesUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllSeries() }
        assert(result == response)
    }
}