package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemTipRecycleBinding

class ViewHolderTipAnswer(val binding: ItemTipRecycleBinding): RecyclerView.ViewHolder(binding.root)
class AnswerListInTipAdapter(val context: Context, val datas:MutableList<TipDetailActivity.TipAnsListItem>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderTipAnswer(ItemTipRecycleBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolderTipAnswer).binding
        val model = datas!![position]

        binding.itemTipFirstmajor.text = model.first
        binding.itemTipSecondmajor.text = model.second
        binding.itemTipContent.text = model.content
        binding.itemTipTime.text = model.time
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }
}