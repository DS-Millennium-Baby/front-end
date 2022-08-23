package com.example.millennium_baby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.millennium_baby.databinding.ActivityMajorMainBinding
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

        binding.majorHeadQna.adapter = viewPagerFragmentAdapter
    }

}

