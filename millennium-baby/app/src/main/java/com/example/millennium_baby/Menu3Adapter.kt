package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemMajorlistBinding

class List3ViewHolder(val binding: ItemMajorlistBinding): RecyclerView.ViewHolder(binding.root)
class Menu3Adapter (val context: Context, val datas : MutableList<MenuActivity.MenuDatas>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return datas?.size?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return List3ViewHolder(
            ItemMajorlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as List3ViewHolder).binding

        when (position){
            in 33..37-> {
                val model = datas!![position]
                binding.majorTitle.text = model.TITLE
            }
            else -> binding.majorTitle.visibility = View.GONE
        }

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