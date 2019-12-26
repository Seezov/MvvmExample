package com.resocoder.mvvmbasicstut.utilities

import com.resocoder.mvvmbasicstut.db.FakeDatabase
import com.resocoder.mvvmbasicstut.repositories.QuoteRepository


object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}