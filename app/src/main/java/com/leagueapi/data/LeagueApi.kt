package com.leagueapi.data

import com.leagueapi.model.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class LeagueApi {
    companion object {
        const val BASE_URL = "https://ddragon.leagueoflegends.com/"

        fun getRetrofit2Api():RetrofitApiInterface{
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(RetrofitApiInterface::class.java)
        }
    }
}

interface RetrofitApiInterface{

    @GET("cdn/14.7.1/data/en_US/champion.json")
    suspend fun getChampions(): Response
}