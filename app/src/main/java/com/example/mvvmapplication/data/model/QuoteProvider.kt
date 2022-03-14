package com.example.mvvmapplication.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}