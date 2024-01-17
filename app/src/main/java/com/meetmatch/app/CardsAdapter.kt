package com.meetmatch.app

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.meetmatch.app.databinding.CardItemBinding
import java.lang.Exception
import java.util.Random

class CardsAdapter: BaseAdapter() {

    var data = mutableListOf<Int>()
    var callbacks = mutableListOf<((Int)-> Unit)?>()
    val random = Random()
    val arr = arrayOf(R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6,R.drawable.t7,
        R.drawable.t8,R.drawable.t9,R.drawable.t10,R.drawable.t11,R.drawable.t12,R.drawable.t13,R.drawable.t14,
        R.drawable.t15,R.drawable.t16,R.drawable.t17,R.drawable.t18,R.drawable.t19,R.drawable.t20,R.drawable.t21,
        R.drawable.t22,R.drawable.t23,R.drawable.t24,R.drawable.t25,R.drawable.t26,R.drawable.t27,R.drawable.t28,
        R.drawable.t29,R.drawable.t30,R.drawable.t31,R.drawable.t32,R.drawable.t33,R.drawable.t34,R.drawable.t35,
        R.drawable.t36,R.drawable.t37,R.drawable.t38,R.drawable.t39,R.drawable.t40,R.drawable.t41,R.drawable.t42,
        R.drawable.t43,R.drawable.t44,
        )

    init {

        for(i in 0..20) {
            data.add(arr[random.nextInt(arr.size)])
            callbacks.add(null)
        }
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        binding.card.setImageResource(data[position])
        callbacks[position] = {
            val prefs = parent.context.getSharedPreferences("prefs",Context.MODE_PRIVATE)
            val set = prefs.getStringSet("history",HashSet<String>())!!
            val set1 = HashSet<String>()
            set1.addAll(set)
            try {
                set1.add("${data[position]}|${it}")
                prefs.edit().putStringSet("history",set1).apply()
            } catch (e: Exception) {

            }
            binding.imageView6.setImageResource(it)
            binding.card.setColorFilter(ContextCompat.getColor(parent.context, R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
        return binding.root
    }

}