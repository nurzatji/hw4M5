package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration

import com.geektech.lovecalculator.databinding.FragmentCalculatorBinding
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.remote.LoveService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
@AndroidEntryPoint

class CalculatorFragment : Fragment() {


    private lateinit var binding: FragmentCalculatorBinding

    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(viewLifecycleOwner) {
                        val bundle = Bundle()
                        bundle.putSerializable("RESULT", it)
                        findNavController().navigate(R.id.resultFragment, bundle)
                    }
                }
            }

    }

    companion object{
        const val PREF_SEEN = "PREF_SEEN"

        }}

