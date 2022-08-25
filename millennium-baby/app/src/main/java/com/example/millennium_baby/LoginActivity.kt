package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.millennium_baby.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 실행
        binding.btnLogin.setOnClickListener {
            // 서버 호출
            val inputID = binding.inputEmail.text.toString() // 아이디에 대한 String
            val inputPW = binding.inputPassword.text.toString() // 비밀번호에 대한 String

            // DB에 저장된 아이디 값
            val call: Call<LoginRes> = MyApplication.networkServiceUsers.login(
                LoginReq(inputID, inputPW)
            )

            call?.enqueue(object : Callback<LoginRes> {
                override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
                    if(response.isSuccessful){
                        Log.d("mobileApp", "$response ${response.body()}")

                         if(response.body()?.loginSuccess == "false"){
                             Toast.makeText(baseContext, "아이디 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                         } else if(response.body()?.loginSuccess == "true"){
                             // 프리퍼런스에 값 저장
                            SaveSharedPreference.setUserEmail(baseContext, inputID)
                            SaveSharedPreference.setUserName(baseContext, response.body()!!.userName)
                            SaveSharedPreference.setUserID(baseContext, response.body()!!.userID)
                             SaveSharedPreference.setFirstMajor(baseContext, response.body()!!.firstMajor)
                             SaveSharedPreference.setSecondMajor(baseContext, response.body()!!.secondMajor)

                             // 메인 페이지로 이동
                             val intent = Intent(baseContext, MainActivity::class.java)
                             startActivity(intent)
                             finish()
                         }


                    }
                }

                override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                    Log.d("mobileApp", "onFailure $t")
                    Toast.makeText(baseContext, "아이디 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                }
            })


            // 액티비티 이동

            
            // 프리퍼런스 저장
        }
    }
}