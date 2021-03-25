package com.userfaltakas.newsapp.ui.activity

import androidx.lifecycle.ViewModel
import com.userfaltakas.newsapp.repository.NewsRepository

class NewsViewModel(val newsRepository: NewsRepository): ViewModel() {
}