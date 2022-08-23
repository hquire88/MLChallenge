package com.example.marvelchallenger.domain

import com.example.marvelchallenger.data.models.ComicModel
import com.example.marvelchallenger.data.models.DataModel
import com.example.marvelchallenger.data.models.ResultModel
import com.example.marvelchallenger.data.models.ThumbnailModel
import com.example.marvelchallenger.data.repositories.ComicsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetSelectedComicUseCaseTest{
    @RelaxedMockK
    private lateinit var repository : ComicsRepository

    lateinit var getComicsUseCase: GetComicsUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getComicsUseCase = GetComicsUseCase(repository)
    }

    @Test
    fun whenRunAPIRecieveASeries() = runBlocking {
        //Given
        val comics = ComicModel(123, "Comic IronMan", "Comics de IronMan", 50, ThumbnailModel("www.imagen.com", ".jpg"), "www.resource.com")
        val data: DataModel<ComicModel> = DataModel(1500,20, arrayListOf(comics, comics))
        val result: ResultModel<ComicModel> = ResultModel(200, "Ok", data)
        coEvery { repository.getAllComics() } returns result

        //When
        val response = getComicsUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllComics() }
        assert(result == response)
    }
}