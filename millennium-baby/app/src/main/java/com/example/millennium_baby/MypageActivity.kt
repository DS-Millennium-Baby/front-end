package com.example.millennium_baby

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.millennium_baby.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // drop box: 전공 변경
        val firstAdapter = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFirst.adapter = firstAdapter

        val secondAdapter = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSecond.adapter = secondAdapter


        // 내가 질문한 목록
        binding.writingQuestion.setOnClickListener {
            val intent = Intent(this, MyQuestionActivity::class.java)
            intent.putExtra("page","writing")
            startActivity(intent)
        }

        // 내가 답변한 질문 목록
        binding.answerQuestion.setOnClickListener {
            val intent = Intent(this, MyQuestionActivity::class.java)
            intent.putExtra("page","answer")
            startActivity(intent)
        }

        var eventhandler_save = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1== DialogInterface.BUTTON_POSITIVE){
                    // 저장했던 preference clear
                    SaveSharedPreference.clearAll(baseContext)

                    Toast.makeText(baseContext, "로그아웃을 성공하였습니다.", Toast.LENGTH_SHORT)

                    // StartActivity로 이동
                    val intent = Intent(baseContext, StartActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }


        var builder_logout = AlertDialog.Builder(this)
            .setTitle("로그아웃")
            .setMessage("로그아웃 하시겠습니까?")
            .setPositiveButton("네!", eventhandler_save)
            .setNegativeButton("아니오", null)
            .setCancelable(true)

        // 로그아웃
        binding.settingLogout.setOnClickListener {
            // 로그아웃 창 띄우기
            builder_logout.show()
        }

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