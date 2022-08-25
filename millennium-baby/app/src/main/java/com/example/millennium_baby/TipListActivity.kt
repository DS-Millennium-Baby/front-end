package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityTipListBinding

class TipListActivity : AppCompatActivity() {
    lateinit var binding : ActivityTipListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listTipWriting.setOnClickListener {
            val intent = Intent(this, WritingTipActivity::class.java)
            startActivity(intent)
        }

        // 리사이클러 뷰
        displayRecyclerView(exampleDatas())
    }

    data class TipListItem(val title: String, val time: String, val first: String, val second: String, val content: String)

    private fun exampleDatas(): MutableList<TipListItem>{
        var data = mutableListOf<TipListItem>()
        data.add(TipListItem(
                "제목입니다1.",
                "08.20. 14:05",
                "컴퓨터공학전공",
                "사이버보안전공",
                "내용내용1"
            )
        )
        data.add(TipListItem(
                "제목입니다2.",
                "08.20. 14:07",
                "사이버보안전공",
                "컴퓨터공학전공",
                "내용내용2"
            )
        )
        return data
    }

    private fun displayRecyclerView(data: MutableList<TipListItem>){
        val TipsearchAdapter =  TipListAdapter(this, data)
        binding.tipSearchRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tipSearchRecyclerView.adapter = TipsearchAdapter // data array

        // 리사이클러뷰 이벤트 처리
        TipsearchAdapter.setItemClickListener(object: TipListAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(baseContext, TipDetailActivity::class.java)
                intent.putExtra("tip", "detailTip")
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