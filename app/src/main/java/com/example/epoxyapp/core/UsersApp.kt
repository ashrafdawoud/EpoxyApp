package com.example.epoxyapp.core

import android.app.Application
import com.example.epoxyapp.data.di.repositoryModule
import com.example.epoxyapp.data.di.serviceApiModule
import com.example.epoxyapp.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
class UsersApp : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@UsersApp)
      modules(
        listOf(
          viewModelModule,
          repositoryModule,
          serviceApiModule
        )
      )
    }
  }
}