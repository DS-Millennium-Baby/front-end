package com.example.millennium_baby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemRecentlyQnaBinding
import com.example.millennium_baby.databinding.ItemRecentlyTipBinding

class Item2ViewHolder(val binding: ItemRecentlyTipBinding): RecyclerView.ViewHolder(binding.root)
class TipAdapter(val fragment : TipFragment, val datas : MutableList<TipFragment.Data>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Item2ViewHolder(ItemRecentlyTipBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as Item2ViewHolder).binding
        val model = datas!![position]

        binding.itemRecentlyQnaTitle.text = model.title
        binding.itemRecentlyQnaMajor1.text = model.major_1
        binding.itemRecentlyQnaMajor2.text = model.major_2

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }

    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener: OnItemClickListener
}