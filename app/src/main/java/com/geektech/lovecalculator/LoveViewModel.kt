package com.geektech.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.remote.LoveModel

class LoveViewModel : ViewModel(){
    private val repository = Repository()

    fun qetLiveLoveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return  repository.getPecrentage(firstName,secondName)

}
}