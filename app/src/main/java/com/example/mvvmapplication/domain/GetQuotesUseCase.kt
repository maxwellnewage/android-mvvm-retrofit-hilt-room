package com.example.mvvmapplication.domain

import com.example.mvvmapplication.data.QuoteRepository
import com.example.mvvmapplication.data.database.entities.toDatabase
import com.example.mvvmapplication.data.model.QuoteModel
import com.example.mvvmapplication.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}