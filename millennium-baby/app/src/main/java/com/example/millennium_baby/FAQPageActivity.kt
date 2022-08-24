package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import com.example.millennium_baby.databinding.ActivityFaqpageBinding

class FAQPageActivity : AppCompatActivity() {

    lateinit var binding : ActivityFaqpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqpageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.faq1Visiblebtn.setOnClickListener{
            binding.faq1Visiblebtn.visibility  = View.GONE
            binding.faq1Invisiblebtn.visibility = View.VISIBLE
        }
        binding.faq1Invisiblebtn.setOnClickListener{
            binding.faq1Visiblebtn.visibility  = View.VISIBLE
            binding.faq1Invisiblebtn.visibility = View.GONE
        }

        binding.faq2Visiblebtn.setOnClickListener{
            binding.faq2Visiblebtn.visibility  = View.GONE
            binding.faq2Invisiblebtn.visibility = View.VISIBLE
        }
        binding.faq2Invisiblebtn.setOnClickListener{
            binding.faq2Visiblebtn.visibility  = View.VISIBLE
            binding.faq2Invisiblebtn.visibility = View.GONE
        }

        binding.faq3Visiblebtn.setOnClickListener{
            binding.faq3Visiblebtn.visibility  = View.GONE
            binding.faq3Invisiblebtn.visibility = View.VISIBLE
        }
        binding.faq3Invisiblebtn.setOnClickListener{
            binding.faq3Visiblebtn.visibility  = View.VISIBLE
            binding.faq3Invisiblebtn.visibility = View.GONE
        }
    }
}