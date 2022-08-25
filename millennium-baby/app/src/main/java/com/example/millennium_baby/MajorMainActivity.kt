package com.example.millennium_baby

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    val FragmentList = listOf<Fragment>(QnAFragment(), TipFragment())

    override fun getItemCount(): Int {
        return FragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentList[position]
    }
}

class MajorMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMajorMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        binding = ActivityMajorMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

}

