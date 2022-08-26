package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.millennium_baby.databinding.ActivitySplashBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val backgroundExecutor : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        val mainExecutor : Executor = ContextCompat.getMainExecutor(this)
        backgroundExecutor.schedule({
            mainExecutor.execute{
                val intent = Intent(applicationContext, StartActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3, TimeUnit.SECONDS)


    }
}