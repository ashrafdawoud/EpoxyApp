package com.example.epoxyapp.presentation.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxyapp.data.utils.ARTICLE_URL
import com.example.epoxyapp.databinding.ActivityMainBinding
import com.example.epoxyapp.model.NewsRsm
import com.example.epoxyapp.presentation.detailsActivity.DetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  lateinit var epoxyController: MainController
  private val viewModel:NewsViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initialEpoxyController()
    setupEpoxyRV()
    updateArticles()
  }

  private fun initialEpoxyController() {
    epoxyController = MainController { handleClickItem(it) }
  }

  private fun handleClickItem(article: NewsRsm.Article) {
    startActivity(Intent(this, DetailsActivity::class.java).putExtra(ARTICLE_URL, article))
  }

  private fun setupEpoxyRV() {
    binding.epoxyRecyclerView.apply {
      setController(epoxyController)
      addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VISIBLE))
    }
  }

  private fun updateArticles() {
    viewModel.breakingNews.observe(this) {
      epoxyController.isLoading = true

      epoxyController.articles = it.articles as MutableList<NewsRsm.Article>
    }
  }
}