package com.example.mvvmapplication.data

import com.example.mvvmapplication.data.database.dao.QuoteDao
import com.example.mvvmapplication.data.database.entities.QuoteEntity
import com.example.mvvmapplication.data.network.QuoteService
import com.example.mvvmapplication.domain.model.Quote
import com.example.mvvmapplication.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
    ) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}