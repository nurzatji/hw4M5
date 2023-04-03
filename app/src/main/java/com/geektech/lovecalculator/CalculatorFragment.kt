package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentCalculatorBinding
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculatorFragment : Fragment() {


    private lateinit var binding: FragmentCalculatorBinding
val viewModel:LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initListener() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.qetLiveLoveModel(etFirstName.text.toString(), etSecondName.text.toString()).observe(this@CalculatorFragment,
                    Observer {
                        Log.e("ololo","initClickers: $it")
                    })
                LoveService().api.getPercentage(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("ololo", "onResponse: ${response.body()}")
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf("result" to response.body())
                            )
                            etFirstName.text.clear()
                            etSecondName.text.clear()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onResponse: ${t.message}")
                    }
                })
            }
        }
    }
}