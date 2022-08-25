package com.example.millennium_baby

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.millennium_baby.databinding.ActivityMajorMainBinding

import java.util.*


class MajorMainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var transaction : FragmentTransaction
    lateinit var binding : ActivityMajorMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMajorMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //최신 글 fragment 설치하기
        transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.major_head, QnAFragment())
        transaction.commit()

        //텍스트 버튼을 누르면 fragment 전환하기
        binding.majorRecentlyQna.setOnClickListener(this)
        binding.majorRecentlyTips.setOnClickListener(this)

/*
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
*/

    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(p0: View?) {
        transaction = supportFragmentManager.beginTransaction()
        when(p0?.id){
            R.id.major_recently_qna -> {
                binding.majorRecentlyQna.setTextColor(Color.parseColor("#864355"))
                binding.majorRecentlyQna.setTypeface(null, Typeface.BOLD)
                binding.majorRecentlyTips.setTextColor(Color.parseColor("#A38376"))
                binding.majorRecentlyTips.setTypeface(null, Typeface.NORMAL)
                binding.intoPage.setOnClickListener {
                    val intent = Intent(baseContext, QuestionListActivity::class.java)
                    intent.putExtra("major", "randomMajor")
                    startActivity(intent)
                }
                transaction.replace(R.id.major_head, QnAFragment())
                transaction.commit()
            }
            R.id.major_recently_tips -> {
                binding.majorRecentlyQna.setTextColor(Color.parseColor("#A38376"))
                binding.majorRecentlyQna.setTypeface(null, Typeface.NORMAL)
                binding.majorRecentlyTips.setTextColor(Color.parseColor("#864355"))
                binding.majorRecentlyTips.setTypeface(null, Typeface.BOLD)
                binding.intoPage.setOnClickListener {
                    //팁 상세 페이지로 이동
                    /*val intent = Intent(baseContext, MajorMainActivity::class.java)
                    intent.putExtra("major", "randomMajor")
                    startActivity(intent)*/
                }
                transaction.replace(R.id.major_head, TipFragment())
                transaction.commit()
            }
        }
    }
}

