package com.example.epoxyapp.presentation.mainActivity

import com.airbnb.epoxy.EpoxyController
import com.bumptech.glide.Glide
import com.example.epoxyapp.R
import com.example.epoxyapp.data.epoxyFile.LoadingEpoxyModel
import com.example.epoxyapp.data.epoxyFile.ViewBindingKotlinModel
import com.example.epoxyapp.databinding.ItemArticleBinding
import com.example.epoxyapp.model.NewsRsm.Article

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 22/04/2022
 */
class MainController(
  private val onClickedCallback: (Article) -> Unit
) : EpoxyController() {

  var isLoading: Boolean = false
    set(value) {
      field = value
      if (field) {
        requestModelBuild()
      }
    }

  var articles = mutableListOf<Article>()
    set(value) {
      field = value
      isLoading = false
      requestModelBuild()
    }

  override fun buildModels() {

    if (isLoading) {
      LoadingEpoxyModel().id("loading_state").addTo(this)
      return
    }

    if (articles.isEmpty()) {
      return
    }

    articles.forEach { article ->
      ArticleEpoxyModel(article, onClickedCallback)
        .id(article.source.id)
        .addTo(this)
    }
  }

  data class ArticleEpoxyModel(
    val article: Article,
    val onClicked: (Article) -> Unit
  ) : ViewBindingKotlinModel<ItemArticleBinding>(R.layout.item_article) {

    override fun ItemArticleBinding.bind() {

      Glide.with(this.root)
        .load(article.urlToImage)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder).into(ivArticleImage)

      with(article) {
        tvTitle.text = title
        tvDescription.text = description
        tvSource.text = source.name
        tvPublishedAt.text = publishedAt

        root.setOnClickListener {
          onClicked(this)
        }
      }
    }
  }
}