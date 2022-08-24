package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityMainBinding
import com.example.millennium_baby.databinding.ActivityMyQuestionBinding

class MyQuestionActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // if 내가 질문한 것
        if(intent.getStringExtra("page") == "writing"){
            binding.answerTitleBox.visibility = View.GONE
            binding.writingTitleBox.visibility = View.VISIBLE
            displayRecyclerView(exampleDatas1())
        }
        // if 내가 답변한 것
        else if (intent.getStringExtra("page") == "answer"){
            binding.answerTitleBox.visibility = View.VISIBLE
            binding.writingTitleBox.visibility = View.GONE
            displayRecyclerView(exampleDatas2())
        }

        // 뒤로가기
        binding.btnMyQueBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    data class MyQueListItem(val major: String, val time: String, val category: String, val title: String, val content: String)

    private fun exampleDatas1(): MutableList<MyQueListItem>{
        var data = mutableListOf<MyQueListItem>()
        data.add(MyQueListItem("컴퓨터공학전공", "22:00", "#제1전공", "제목입니다.", "내용입니다."))
        data.add(MyQueListItem("컴퓨터공학전공", "22:00", "#제1전공", "제목입니다.", "내용입니다."))
        return data
    }

    private fun exampleDatas2(): MutableList<MyQueListItem>{
        var data = mutableListOf<MyQueListItem>()
        data.add(MyQueListItem("사이버보안전공", "22:00", "#제1전공", "제목입니다.", "내용입니다."))
        data.add(MyQueListItem("사이버보안전공", "22:00", "#제1전공", "제목입니다.", "내용입니다."))
        return data
    }

    private fun displayRecyclerView(data: MutableList<MyQueListItem>){
        val myquestionAdapter =  MyQuestionAdapter(this, data)
        binding.myQuestionRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myQuestionRecyclerView.adapter = myquestionAdapter // data array

        // 리사이클러뷰 이벤트 처리
        myquestionAdapter.setItemClickListener(object: MyQuestionAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                // 클릭 시 상세정보 페이지 이동
//                binding.placeBottomSheetPlace.text = data.get(position).title
//                binding.placeBottomSheetAddr.text = data.get(position).venue
//                binding.placeBottomSheetTel.text = data.get(position).reference
//                binding.placeBottomSheetType.text = data.get(position).subjectCategory

            }
        })
    }
}