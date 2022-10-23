package com.example.quotescelebrities.data

import androidx.lifecycle.LiveData
import com.example.quotescelebrities.data.local.daos.QuoteDao
import com.example.quotescelebrities.data.local.entities.QuoteEntity

class QuoteRepositoryAdd (private val quoteDao: QuoteDao) {

    val readAllDaata: LiveData<List<QuoteEntity>> = quoteDao.readAllData()

    suspend fun addQuote(quote: QuoteEntity){
        quoteDao.insert(quote)
    }

}