package com.example.millennium_baby

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.fragment.app.FragmentTransaction
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
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
        // 어댑터
        binding.majorHeadQna.adapter = viewPagerFragmentAdapter

        // 전공에 대한 정보 띄우기
        val majorString = intent.getStringExtra("major")!!
        // DB에 저장된 아이디 값
        val call: Call<MajorRes> = MyApplication.networkServiceMajors.displayMajor(
            major = majorString
        )

        call.enqueue(object : Callback<MajorRes> {
            override fun onResponse(call: Call<MajorRes>, response: Response<MajorRes>) {
                if(response.isSuccessful){
                    Log.d("mobileApp", "${response.body()}")
                    Log.d("mobileApp", "${response.body()?.majorName}")
                    binding.majorHeadBtn.text = response.body()?.majorName
                    binding.majorGraduate.text = response.body()?.graduate
                    binding.majorIntroduce.text = response.body()?.intro
                }
            }

            override fun onFailure(call: Call<MajorRes>, t: Throwable) {
                Log.d("mobileApp", "onFailure $t")
                Toast.makeText(baseContext, "아이디 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        })
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

