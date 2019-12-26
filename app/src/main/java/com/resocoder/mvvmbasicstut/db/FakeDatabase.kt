package com.resocoder.mvvmbasicstut.db

import com.resocoder.mvvmbasicstut.db.dao.FakeQuoteDao


class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: FakeDatabase().also { instance = it }
                }
    }
}