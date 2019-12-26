package com.resocoder.mvvmbasicstut.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.resocoder.mvvmbasicstut.entities.Quote


class FakeQuoteDao {
    private val quoteList = arrayListOf<Quote>()
    private val quotes = MutableLiveData<ArrayList<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<ArrayList<Quote>>
}