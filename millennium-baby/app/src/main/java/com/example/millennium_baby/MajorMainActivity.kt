package com.example.millennium_baby

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.millennium_baby.databinding.ActivityMajorMainBinding
import java.util.*


class MajorMainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var transaction: FragmentTransaction
    lateinit var binding : ActivityMajorMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMajorMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.recently_major, QnAFragment())
        transaction.commit()


        binding.majorRecentlyQna.setOnClickListener(this)
        binding.majorRecentlyTips.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        transaction = supportFragmentManager.beginTransaction()
        when (p0?.id) {
            R.id.major_recently_qna -> {
                transaction.replace(R.id.recently_major, QnAFragment())
                transaction.commit()
                Log.d("log", "질문 페이지")
            }
            R.id.major_recently_tips -> {
                transaction.replace(R.id.recently_major, TipFragment())
                transaction.commit()
                Log.d("log", "팁 페이지")
            }
        }
    }
}

