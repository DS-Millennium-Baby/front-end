package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityTipDetailBinding

class TipDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityTipDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTipDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러 뷰
        val answerAdapter = AnswerListInTipAdapter(this, exampleDatas())
        binding.detailTipAnswerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.detailTipAnswerRecyclerView.adapter = answerAdapter

        // 뒤로가기
        binding.detailBtnBack.setOnClickListener {
            super.onBackPressed()
        }
    }
    data class TipAnsListItem(val time: String, val first: String, val second: String, val content: String)

    private fun exampleDatas(): MutableList<TipAnsListItem>{
        var data = mutableListOf<TipAnsListItem>()
        data.add(TipAnsListItem("11:22", "사이버보안전공", "화학전공","답변을 달았어요1"))
        data.add(TipAnsListItem("11:22", "사이버보안전공", "화학전공","답변을 달았어요1"))

        return data
    }
}