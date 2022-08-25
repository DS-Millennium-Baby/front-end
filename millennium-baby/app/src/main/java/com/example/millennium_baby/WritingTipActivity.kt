package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityWritingTipBinding

class WritingTipActivity : AppCompatActivity() {

    lateinit var binding : ActivityWritingTipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingTipBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_writing_tip)

        //뒤로가기
        binding.btnWritingBack.setOnClickListener{
            super.onBackPressed()
        }
    }
}