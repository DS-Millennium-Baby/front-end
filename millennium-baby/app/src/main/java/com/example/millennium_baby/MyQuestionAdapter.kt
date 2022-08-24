package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemMyQuestionBinding

class ViewHolderMyQuestion(val binding: ItemMyQuestionBinding): RecyclerView.ViewHolder(binding.root)
class MyQuestionAdapter(val context: Context, val datas:MutableList<MyQuestionActivity.MyQueListItem>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderMyQuestion(ItemMyQuestionBinding.inflate(LayoutInflater.from(parent.context), parent,false ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolderMyQuestion).binding
        val model = datas!![position]

        binding.itemMyQueTitle.text = model.title
        binding.itemMyQueMajor.text = model.major
        binding.itemMyQueContent.text = model.content
        binding.itemMyQueTime.text = model.time
        binding.itemMyQueCategory.text = model.category

        // (1) 리스트 내 항목 클릭 시 onClick() 호출
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }

    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

}