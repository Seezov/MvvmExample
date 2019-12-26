package com.resocoder.mvvmbasicstut.utilities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.resocoder.mvvmbasicstut.repositories.QuoteRepository
import com.resocoder.mvvmbasicstut.viewmodels.QuotesViewModel


class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}