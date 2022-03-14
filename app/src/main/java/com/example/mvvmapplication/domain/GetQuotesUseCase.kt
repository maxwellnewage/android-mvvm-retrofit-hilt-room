package com.example.mvvmapplication.domain

import com.example.mvvmapplication.data.QuoteRepository
import com.example.mvvmapplication.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}