package com.example.quotesapp.endpoint

import com.example.quotesapp.models.SaveQuotes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetroFit {

    @GET("$BASE_URL quotes")
    suspend fun getQuotes() : Response<List<SaveQuotes>>


    companion object{
        private const val BASE_URL = "https://type.fit/api/"

        fun create() : RetroFit{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetroFit::class.java)

        }


    }
}