package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.millennium_baby.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // drop box: 전공 변경
        val firstAdapter = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFirst.adapter = firstAdapter

        val secondAdapter = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSecond.adapter = secondAdapter


        // 내가 질문한 목록
        binding.writingQuestion.setOnClickListener {
            val intent = Intent(this, MyQuestionActivity::class.java)
            intent.putExtra("page","writing")
            startActivity(intent)
        }

        // 내가 답변한 질문 목록
        binding.answerQuestion.setOnClickListener {
            val intent = Intent(this, MyQuestionActivity::class.java)
            intent.putExtra("page","answer")
            startActivity(intent)
        }

        // Bottom Bar
        binding.navHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
        binding.navList.setOnClickListener{
            val intent = Intent(this, ListMajorActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
        binding.navMypage.setOnClickListener{
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}