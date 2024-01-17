package com.meetmatch.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.meetmatch.app.databinding.Card1ItemBinding
import com.meetmatch.app.databinding.CardItemBinding

class HistoryAdapter(val list: List<String>): RecyclerView.Adapter<HistoryAdapter.Companion.HistoryHolder>() {


    companion object {
        class HistoryHolder(val binding: Card1ItemBinding): ViewHolder(binding.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
       return HistoryHolder(Card1ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val s = list[position].trim().split("|")
        holder.binding.card.setImageResource(s[0].toInt())
        holder.binding.imageView7.setImageResource(s[1].toInt())
    }
}