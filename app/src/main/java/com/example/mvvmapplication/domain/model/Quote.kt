package com.example.mvvmapplication.domain.model

import com.example.mvvmapplication.data.database.entities.QuoteEntity
import com.example.mvvmapplication.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)