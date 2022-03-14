package com.example.mvvmapplication.model

class QuoteProvider {
    companion object {
        private val quote = listOf (
            QuoteModel(
                "quote 1",
                "Anon"
            ),
            QuoteModel(
                "quote 2",
                "Jhon"
            ),
            QuoteModel(
                "quote 3",
                "Anon"
            ),
            QuoteModel(
                "quote 4",
                "Tomas"
            ),
            QuoteModel(
                "quote 5",
                "Anon"
            ),
            QuoteModel(
                "quote 6",
                "Hilt"
            ),
            QuoteModel(
                "quote 7",
                "Anon"
            ),
        )

        fun randomQuote(): QuoteModel {
            val position = (0..6).random()
            return quote[position]
        }
    }
}