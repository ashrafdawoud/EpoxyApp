package com.example.epoxyapp.data.di

import com.example.epoxyapp.data.network.Api
import com.example.epoxyapp.data.repositories.NewsRepo
import com.example.epoxyapp.data.utils.BASE_URL
import com.example.epoxyapp.presentation.mainActivity.NewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
val viewModelModule = module {
  viewModel { NewsViewModel(newsRep = get()) }
}

val repositoryModule = module {
  single { NewsRepo(apiService = get()) }
}

val serviceApiModule = module {

  fun getRetrofit(): Retrofit {
    val logger = HttpLoggingInterceptor()
    logger.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient().newBuilder()
      .addInterceptor(logger)
      .build()
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build()
  }

  single { getRetrofit() }

  fun getApiService(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
  }

  single { getApiService(retrofit = get()) }
}