package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapplication.model.QuoteModel
import com.example.mvvmapplication.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.randomQuote()
        quoteModel.postValue(currentQuote)
    }
}