package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.millennium_baby.databinding.ActivityRegisterSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterSecondActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nikname = intent.getStringExtra("nikname")!!
        val email = intent.getStringExtra("email")!!
        val password = intent.getStringExtra("password")!!

        // 스피너 작업
        //spinner 변수 생성 및 어댑터 연결
        binding.btnJoin.setOnClickListener {
            registerUser(nikname, email, password)
        }

        val spin2: Spinner = findViewById(R.id.firstspinner2)
        val spin4: Spinner = findViewById(R.id.secondspinner4)
        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner1, android.R.layout.simple_spinner_item
        )
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

        val adapter4 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner4, android.R.layout.simple_spinner_item
        )
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin4.adapter = adapter4
    }

    private fun registerUser(userName: String, email: String, password: String){
        val call: Call<RegisterRes> = MyApplication.networkServiceUsers.register(
            RegisterReq(userName,email, password, binding.firstspinner2.selectedItem.toString(), binding.secondspinner4.selectedItem.toString())
        )

        call?.enqueue(object : Callback<RegisterRes> {
            override fun onResponse(call: Call<RegisterRes>, response: Response<RegisterRes>) {
                if(response.isSuccessful){
                    Log.d("mobileApp", "$response ${response.body()}")

                    Toast.makeText(baseContext, "회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<RegisterRes>, t: Throwable) {
                Log.d("mobileApp", "onFailure $t")
            }
        })
    }
}