package com.resocoder.mvvmbasicstut.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.resocoder.mvvmbasicstut.R
import com.resocoder.mvvmbasicstut.entities.Quote
import com.resocoder.mvvmbasicstut.repositories.QuoteRepository
import kotlinx.android.synthetic.main.activity_quotes.view.*


class QuotesViewModel(
        private val quoteRepository: QuoteRepository
) : ViewModel() {

    fun getQuotes() =quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}