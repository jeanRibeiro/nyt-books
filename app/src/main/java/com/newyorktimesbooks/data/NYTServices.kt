package com.newyorktimesbooks.data

import com.newyorktimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//faz o mapeamento dos endpoints
interface NYTServices {

    //lista os livros
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey : String = "rSviiJpFpX2brfMP68y8EX1nqsOVPg1A",
        @Query("list") List : String = "hardcover-fiction"
    ) : Call<BookBodyResponse>

    //lista livro pelo código
}