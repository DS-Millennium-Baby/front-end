package com.example.millennium_baby

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millennium_baby.databinding.FragmentQnABinding
import com.example.millennium_baby.databinding.FragmentTipBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TipFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TipFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //임의 데이터 추가를 위한 데이터 클래스
    data class Data(val title : String, val major_1 : String, val major_2 : String)
    var datas = mutableListOf<Data>()

    lateinit var binding : FragmentTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTipBinding.inflate(inflater, container, false)

        addData()

        binding.majorHeadItem.layoutManager = LinearLayoutManager(activity)
        binding.majorHeadItem.adapter = TipAdapter(this, datas)

        return binding.root
    }

    fun addData() : MutableList<TipFragment.Data>{
        datas.add(TipFragment.Data("공부 같이 하실 분", "컴퓨터공학전공", "경영학전공"))
        datas.add(TipFragment.Data("이 책을 추천합니다", "사회학전공", "사이버보안전공"))
        datas.add(TipFragment.Data("소모임 인원 모집 중", "경영학전공", "사이버보안전공"))

        return datas
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TipFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TipFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}