package com.example.epoxyapp.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epoxyapp.model.NewsRsm
import com.example.epoxyapp.data.repositories.NewsRepo
import kotlinx.coroutines.launch

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
class NewsViewModel(private val newsRep: NewsRepo) : ViewModel() {

  private val _breakingNews: MutableLiveData<NewsRsm> = MutableLiveData()
  val breakingNews :LiveData<NewsRsm> =_breakingNews

  init {
    getBreakingNews()
  }

  private fun getBreakingNews() {
    viewModelScope.launch {
      val response = newsRep.getBreakNews()
      _breakingNews.setValue(response)

    }
  }
}