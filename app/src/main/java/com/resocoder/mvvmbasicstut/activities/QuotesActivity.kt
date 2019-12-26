package com.resocoder.mvvmbasicstut.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.resocoder.mvvmbasicstut.R
import com.resocoder.mvvmbasicstut.adapters.QuotesAdapter
import com.resocoder.mvvmbasicstut.entities.Quote
import com.resocoder.mvvmbasicstut.viewmodels.QuotesViewModel
import com.resocoder.mvvmbasicstut.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    private val quotesAdapter: QuotesAdapter = QuotesAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
                .get(QuotesViewModel::class.java)

        with(recyclerQuotes) {
            layoutManager = LinearLayoutManager(context)
            adapter = quotesAdapter
        }

        viewModel.getQuotes().observe(this, Observer { quotes ->
            quotesAdapter.updateQuotes(quotes)
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
