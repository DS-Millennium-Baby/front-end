package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gotoFaq.setOnClickListener{
            val intent = Intent(this, FAQPageActivity::class.java)
            startActivity(intent)
        }
    }
}