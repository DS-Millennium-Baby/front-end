package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.millennium_baby.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(SaveSharedPreference.getUserEmail(this)?.length != 0){
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            binding.btnLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            binding.btnNew.setOnClickListener {
                val intent = Intent(this, RegisterFirstActivity::class.java)
                startActivity(intent)
            }
        }


    }
}