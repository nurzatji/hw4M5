package com.geektech.lovecalculator.ui.OnBoard


import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R


import com.geektech.lovecalculator.data.Pref

import com.geektech.lovecalculator.databinding.FragmentOnBoardBinding

import javax.inject.Inject



class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: OnBoardAdapter

    @Inject
    lateinit var pref: Pref

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
   pref = Pref(requireContext())
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(this::onStartClick)
        binding.viewPager.adapter = adapter
        if (pref.isUserSeen()) {
            findNavController().navigate(R.id.calculatorFragment)

        }
    }

    private fun onStartClick() {
       pref.saveUserSeen()
        findNavController().navigate(R.id.onBoard)
    }


}









