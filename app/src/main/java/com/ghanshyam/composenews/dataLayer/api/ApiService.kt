package com.ghanshyam.composenews.dataLayer.api

import com.ghanshyam.composenews.dataLayer.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//import retrofit2.http.
interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadLine(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "Your-Api-Key"
    ) : Response<NewsResponse>

}