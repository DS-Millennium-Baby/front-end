package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityWritingQuestionBinding

class WritingQuestionActivity : AppCompatActivity() {

    lateinit var binding : ActivityWritingQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingQuestionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 뒤로가기
        binding.btnWritingBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}