package com.example.epoxyapp.data.repositories

import com.example.epoxyapp.data.network.Api
import com.example.epoxyapp.model.NewsRsm
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 24/04/2022
 */
class NewsRepoTest {

  @Test
  fun `getBreakNews() with successful request return list of news `() {

    runBlocking {

      //arrange
      val listNews = object : Api {
        override suspend fun getBreakingNews(country: String, apiKey: String): NewsRsm {
          return NewsRsm(
            "ok", 38,
            arrayListOf<NewsRsm.Article>(
              NewsRsm.Article(
                NewsRsm.Article.Source("1", "name"),
                "Rick Noack", "", "", "", "", "", ""
              )
            )
          )
        }
      }

      //act
      val result = listNews.getBreakingNews()

      // assert
      val expected =
        NewsRsm(
          "ok", 38,
          arrayListOf<NewsRsm.Article>(
            NewsRsm.Article(
              NewsRsm.Article.Source("1", "name"),
              "Rick Noack", "", "", "", "", "", ""
            )
          )
        )


      assertEquals(expected, result)

    }
  }
}