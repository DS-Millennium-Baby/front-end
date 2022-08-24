package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityQuestionDetailBinding
import com.example.millennium_baby.databinding.ActivityQuestionListBinding

class QuestionDetailActivity : AppCompatActivity(){
    lateinit var binding: ActivityQuestionDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}