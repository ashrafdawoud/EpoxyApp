package com.example.epoxyapp.data.network

import com.example.epoxyapp.model.NewsRsm
import com.example.epoxyapp.data.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
interface Api {

  @GET("v2/top-headlines")
  suspend fun getBreakingNews(
    @Query("country")
    country:String="us" ,
    @Query("apiKey")
    apiKey:String = API_KEY
  ):NewsRsm
}