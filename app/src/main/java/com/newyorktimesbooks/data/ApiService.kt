package com.newyorktimesbooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


//essa é uma classe singleton
object ApiService {

    private fun initRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    //criando um instância do retrofit associada a classe de serviços onde tem os endpoints da API
    val service: NYTServices = initRetrofit().create(NYTServices::class.java)

}