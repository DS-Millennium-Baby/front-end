package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityQuestionDetailBinding
import com.example.millennium_baby.databinding.ActivityQuestionListBinding

class QuestionDetailActivity : AppCompatActivity(){
    lateinit var binding: ActivityQuestionDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러 뷰
        val answerAdapter =  AnswerListAdapter(this, exampleDatas())
        binding.detailAnswerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.detailAnswerRecyclerView.adapter = answerAdapter // data array

        // 뒤로가기
        binding.detailBtnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    data class AnsListItem(val time: String, val first: String, val second: String, val content: String)

    private fun exampleDatas(): MutableList<AnsListItem>{
        var data = mutableListOf<AnsListItem>()
        data.add(AnsListItem("11:22", "사이버보안전공", "화학전공","답변을 달았어요1"))
        data.add(AnsListItem("11:22", "사이버보안전공", "화학전공","답변을 달았어요1"))

        return data
    }
}