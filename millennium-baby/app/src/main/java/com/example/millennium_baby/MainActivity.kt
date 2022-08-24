package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start()
    }

    //로그인 또는 회원가입 선택 페이지
    fun start(){
        setContentView(R.layout.activity_selectlogin)

        val btn_login: Button = findViewById(R.id.btn_login)
        val btn_new: Button = findViewById(R.id.btn_new)

        btn_login.setOnClickListener{
            //자동로그인
        }
        btn_new.setOnClickListener{
            new()
        }
    }

    //회원가입 - 사용자 정보 작성 페이지
    fun new(){
        setContentView(R.layout.activity_new1)

        val btn_next: Button = findViewById(R.id.btn_next)

        btn_next.setOnClickListener{
            chooseMajor()
        }
    }

    //회원가입 - 전공 선택 페이지
    fun chooseMajor(){
        setContentView(R.layout.activity_new2)

        val btn_join: Button = findViewById(R.id.btn_join)
        //spinner 변수 생성 및 어댑터 연결
        val spin1: Spinner = findViewById(R.id.spinner)
        val spin2: Spinner = findViewById(R.id.spinner2)
        val spin3: Spinner = findViewById(R.id.spinner3)
        val spin4: Spinner = findViewById(R.id.spinner4)
        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner1, android.R.layout.simple_spinner_item
        )
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin1.adapter = adapter1
        val adapter2 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner2, android.R.layout.simple_spinner_item
        )
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin2.adapter = adapter2
        val adapter3 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner3, android.R.layout.simple_spinner_item
        )
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin3.adapter = adapter3
        val adapter4 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner4, android.R.layout.simple_spinner_item
        )
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin4.adapter = adapter4

        //회원가입 버튼 클릭 시 동작
        btn_join.setOnClickListener{
            //회원자료 DB 저장 및 로그인 완료
        }
    }
}