package com.example.mvvmapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmapplication.data.database.dao.QuoteDao
import com.example.mvvmapplication.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}