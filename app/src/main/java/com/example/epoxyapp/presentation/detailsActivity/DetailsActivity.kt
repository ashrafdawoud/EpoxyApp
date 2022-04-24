package com.example.epoxyapp.presentation.detailsActivity

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.epoxyapp.data.utils.ARTICLE_URL
import com.example.epoxyapp.databinding.ActivityDetailsBinding
import com.example.epoxyapp.model.NewsRsm.Article

class DetailsActivity : AppCompatActivity() {

  lateinit var binding: ActivityDetailsBinding
  private val article: Article by lazy { intent.getSerializableExtra(ARTICLE_URL) as Article }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsBinding.inflate(layoutInflater)
    setContentView(binding.root)
    loadingUrl()
  }

  private fun loadingUrl() {
    with(binding) {
      iconLoading.show()
      wvArticle.apply {
        webViewClient = object : WebViewClient() {
          override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return true
          }

          override fun onPageFinished(view: WebView?, url: String?) {
            binding.iconLoading.hide()
          }
        }
        loadUrl(article.url)
      }
    }
  }
}