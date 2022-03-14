package com.example.mvvmapplication.domain

import com.example.mvvmapplication.data.QuoteRepository
import com.example.mvvmapplication.data.model.QuoteModel
import com.example.mvvmapplication.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = quoteRepository.getAllQuotesFromDatabase()

        if(quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }

        return null
    }
}