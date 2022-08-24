package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemAnswerRecycleBinding

class ViewHolderAnswer(val binding: ItemAnswerRecycleBinding): RecyclerView.ViewHolder(binding.root)
class AnswerListAdapter(val context: Context, val datas:MutableList<QuestionDetailActivity.AnsListItem>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderAnswer(ItemAnswerRecycleBinding.inflate(LayoutInflater.from(parent.context), parent,false ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolderAnswer).binding
        val model = datas!![position]

        binding.itemAnsFirstmajor.text = model.first
        binding.itemAnsSecondmajor.text = model.second
        binding.itemAnsContent.text = model.content
        binding.itemAnsTime.text = model.time

    }
    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }
}