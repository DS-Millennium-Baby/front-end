package com.example.millennium_baby

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millennium_baby.databinding.ItemQuestionRecycleBinding

class ViewHolderQuestion(val binding: ItemQuestionRecycleBinding): RecyclerView.ViewHolder(binding.root)
class QuestionListAdapter(val context: Context, val datas:MutableList<QuestionListActivity.QueListItem>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderQuestion(ItemQuestionRecycleBinding.inflate(LayoutInflater.from(parent.context), parent,false ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolderQuestion).binding
        val model = datas!![position]

        binding.itemQueTitle.text = model.title
        binding.itemQueFirstmajor.text = model.first
        binding.itemQueSecondmajor.text = model.second
        binding.itemQueContent.text = model.content
        binding.itemQueTime.text = model.time

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