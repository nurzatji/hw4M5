package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository):ViewModel(){
    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPecrentage(firstName, secondName)
    }
}

