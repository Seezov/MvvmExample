package com.resocoder.mvvmbasicstut.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.resocoder.mvvmbasicstut.R
import com.resocoder.mvvmbasicstut.entities.Quote

class QuotesAdapter(private val items: ArrayList<Quote>) : RecyclerView.Adapter<QuotesAdapter.UserViewHolder>() {

    fun updateQuotes(newQuotes: List<Quote>) {
        items.clear()
        items.addAll(newQuotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
            UserViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
            )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtQuote: TextView = view.findViewById(R.id.txtQuote)

        fun onBind(position: Int) {
            val selectedItem = items[position]

            txtQuote.text = selectedItem.toString()
        }
    }
}