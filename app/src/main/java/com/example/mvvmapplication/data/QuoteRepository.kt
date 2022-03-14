package com.example.mvvmapplication.data

import com.example.mvvmapplication.data.model.QuoteModel
import com.example.mvvmapplication.data.model.QuoteProvider
import com.example.mvvmapplication.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}