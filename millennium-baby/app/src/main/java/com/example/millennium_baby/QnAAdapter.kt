package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemRecentlyQnaBinding

class ItemViewHolder(val binding:ItemRecentlyQnaBinding): RecyclerView.ViewHolder(binding.root)
class QnAAdapter (val context: Context, val fragment: QnAFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
        return ItemViewHolder(ItemRecentlyQnaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val binding = (holder as ItemViewHolder).binding
        binding.itemRecentlyQnaTitle.text = "제목"
        binding.itemRecentlyQnaMajor1.text = "제 1전공"
        binding.itemRecentlyQnaMajor2.text = "제 2전공"

        binding.itemRecentlyQnaTitle.setOnClickListener{
            fragment.onStart()
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return 3
    }

}