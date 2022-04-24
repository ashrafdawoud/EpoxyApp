package com.example.epoxyapp.data.repositories

import com.example.epoxyapp.data.network.Api
import com.example.epoxyapp.model.NewsRsm
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 24/04/2022
 */
@RunWith(MockitoJUnitRunner::class)
class NewsRepoTest {

  @Mock
  lateinit var listnews:NewsRsm

  @Mock
  lateinit var newsRepo: NewsRepo




  @Test
  fun `getBreakNews() with successful request return list of news `() = runBlocking{
    //given
    `when`(newsRepo.getBreakNews()).thenReturn(listnews)
    // when
    val result = newsRepo.getBreakNews()
    //then
    assertEquals(listnews,result)
  }
}