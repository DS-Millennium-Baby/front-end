package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityListMajorBinding

class ListMajorActivity : AppCompatActivity() {

    lateinit var binding : ActivityListMajorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListMajorBinding.inflate(layoutInflater)
        setContentView(binding.root)

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