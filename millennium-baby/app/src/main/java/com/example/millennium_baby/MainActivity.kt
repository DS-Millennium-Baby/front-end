package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("mobileApp", "${SaveSharedPreference.getUserEmail(this)}")
        Log.d("mobileApp", "${SaveSharedPreference.getUserID(this)}")
        Log.d("mobileApp", "${SaveSharedPreference.getUserName(this)}")
        Log.d("mobileApp", "${SaveSharedPreference.getFirstMajor(this)}")
        Log.d("mobileApp", "${SaveSharedPreference.getSecondMajor(this)}")


        // FAQ
        binding.gotoFaq.setOnClickListener{
            val intent = Intent(this, FAQPageActivity::class.java)
            startActivity(intent)
        }
        
        // router: 전공과 관련된 질문 3개 불러오기
        // 사용자의 전공을 배열에 넣기
        val firstMajor = SaveSharedPreference.getFirstMajor(this)
        val secondMajor = SaveSharedPreference.getSecondMajor(this)
        val myMajorarray = arrayListOf(firstMajor, secondMajor)
        val random = Random
        val randomMajorANum = random.nextInt(myMajorarray.size)

        val call: Call<QuestionThreeListRes> = MyApplication.networkServiceQuestions.displayQuestionThree(
            question = myMajorarray[randomMajorANum]!!
        )

        call.enqueue(object : Callback<QuestionThreeListRes> {
            override fun onResponse(call: Call<QuestionThreeListRes>, response: Response<QuestionThreeListRes>) {
                if(response.isSuccessful){

                }
            }

            override fun onFailure(call: Call<QuestionThreeListRes>, t: Throwable) {
                Log.d("mobileApp", "onFailure $t")
                Toast.makeText(baseContext, "아이디 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        })



        // router: 전체 팁 불러오기


        // 랜덤으로 학과 정보 띄우기
        var majorArray : Array<String> = resources.getStringArray(R.array.major)

        val num = random.nextInt(majorArray.size)
        Log.d("mobileApp", "$num")
        // 임의의 전공 보여주기
        val randomMajor = majorArray[num]

        binding.random.text = randomMajor + ", \n 어떤 학과일까요?"
        binding.random.setOnClickListener {
            val intent = Intent(this, MajorMainActivity::class.java)
            intent.putExtra("major", randomMajor)
            startActivity(intent)
        }

        // Bottom Bar
        binding.navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
        binding.navList.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
        binding.navMypage.setOnClickListener {
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()

        }
    }

}