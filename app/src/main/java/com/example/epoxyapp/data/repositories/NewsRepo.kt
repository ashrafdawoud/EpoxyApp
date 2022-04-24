package com.example.epoxyapp.data.repositories

import com.example.epoxyapp.data.network.Api
import com.example.epoxyapp.model.NewsRsm
import retrofit2.Response

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
class NewsRepo(private val apiService: Api) {
  suspend fun getBreakNews(): NewsRsm {
    return apiService.getBreakingNews()
  }
}