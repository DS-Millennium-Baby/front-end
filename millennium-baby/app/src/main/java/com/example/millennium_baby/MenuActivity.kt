package com.example.millennium_baby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {
    data class MenuDatas(val TITLE: String)

    lateinit var binding : ActivityMenuBinding
    var datas = mutableListOf<MenuDatas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()

        val adapter_g = MenuAdapter(this, datas)
        val adapter_s = Menu2Adapter(this, datas)
        val adapter_a = Menu3Adapter(this, datas)

        binding.majorTitleGlobal.layoutManager = LinearLayoutManager(this)
        binding.majorTitleGlobal.adapter = adapter_g

        binding.majorTitleScience.layoutManager = LinearLayoutManager(this)
        binding.majorTitleScience.adapter = adapter_s

        binding.majorTitleArt.layoutManager = LinearLayoutManager(this)
        binding.majorTitleArt.adapter = adapter_a

        adapter_g.setItemClickListener(object: MenuAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Log.d("log", "클릭")

                val intent = Intent(baseContext, MajorMainActivity::class.java)
                intent.putExtra("major", "randomMajor")
                startActivity(intent)
            }
        })

        adapter_s.setItemClickListener(object: Menu2Adapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Log.d("log", "클릭")

                val intent = Intent(baseContext, MajorMainActivity::class.java)
                intent.putExtra("major", "randomMajor")
                startActivity(intent)
            }
        })

        adapter_a.setItemClickListener(object: Menu3Adapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Log.d("log", "클릭")

                val intent = Intent(baseContext, MajorMainActivity::class.java)
                intent.putExtra("major", "randomMajor")
                startActivity(intent)
            }
        })
    }

    fun addData() : MutableList<MenuDatas> {

        val string = arrayListOf<String>(
            "국어국문학전공",
            "일어일문학전공",
            "중어중문학전공",
            "영어영문학전공",
            "불어불문학전공",
            "독어독문학전공",
            "스페인어전공",
            "사학전공",
            "철학전공",
            "미술사학전공",
            "사회학전공",
            "문화인류학전공",
            "경영학전공",
            "회계학전공",
            "국제통상학전공",
            "법학전공",
            "문헌정보학전공",
            "심리학전공",
            "아동가족학전공",
            "사회복지학전공",
            "정치외교학전공",
            "유아교육과",
            "의상디자인전공",
                "컴퓨터공학전공",
                "IT미디어공학전공",
                "사이버보안전공",
                "소프트웨어전공",
                "바이오공학전공",
                "수학전공",
                "정보통계학전공",
                "화학전공",
                "식품영양학전공",
                "생활체육학전공",
            "동양화전공",
            "서양화전공",
            "실내디자인전공",
            "시각디자인전공",
            "텍스타일디자인전공")

        for(i in 0..37){
            datas.add(MenuDatas("${string[i]}"))
        }

        return datas
    }
}

