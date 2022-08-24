package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityQuestionListBinding

class QuestionListActivity : AppCompatActivity() {
    lateinit var binding : ActivityQuestionListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}