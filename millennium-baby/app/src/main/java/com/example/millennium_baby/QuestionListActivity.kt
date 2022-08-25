package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityQuestionListBinding

class QuestionListActivity : AppCompatActivity() {
    lateinit var binding : ActivityQuestionListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 작성하기
        binding.listQueWriting.setOnClickListener {
            val intent = Intent(this, WritingQuestionActivity::class.java)
            startActivity(intent)
        }

        // 리사이클러 뷰
        displayRecyclerView(exampleDatas())
    }

    data class QueListItem(val title: String, val time: String, val first: String, val second: String, val content: String)

    private fun exampleDatas(): MutableList<QueListItem>{
        var data = mutableListOf<QueListItem>()
        data.add(QueListItem("제목입니다1.", "08.20. 14:05", "컴퓨터공학전공", "사이버보안전공", "내용내용1"))
        data.add(QueListItem("제목입니다2.", "08.20. 14:07", "사이버보안전공", "컴퓨터공학전공", "내용내용2"))
        return data
    }
    
    private fun displayRecyclerView(data: MutableList<QueListItem>){
        val searchAdapter =  QuestionListAdapter(this, data)
        binding.questionSearchRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.questionSearchRecyclerView.adapter = searchAdapter // data array

        // 리사이클러뷰 이벤트 처리
        searchAdapter.setItemClickListener(object: QuestionListAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(baseContext, QuestionDetailActivity::class.java)
                intent.putExtra("que", "detailQue")
                startActivity(intent)
                // 클릭 시 상세정보 페이지 이동
//                binding.placeBottomSheetPlace.text = data.get(position).title
//                binding.placeBottomSheetAddr.text = data.get(position).venue
//                binding.placeBottomSheetTel.text = data.get(position).reference
//                binding.placeBottomSheetType.text = data.get(position).subjectCategory

            }
        })
    }
}