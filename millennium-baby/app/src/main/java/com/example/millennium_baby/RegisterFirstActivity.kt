package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.millennium_baby.databinding.ActivityRegisterFirstBinding

class RegisterFirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 다음으로 이동
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, RegisterSecondActivity::class.java)
            intent.putExtra("nikname", binding.editTextPersonName.text.toString())
            intent.putExtra("email", binding.editTextEmailAddress.text.toString())
            intent.putExtra("password", binding.editTextPassword.text.toString())
            startActivity(intent)
        }

    }
}