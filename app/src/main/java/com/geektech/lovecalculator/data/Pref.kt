package com.geektech.lovecalculator.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref (context: Context) {
    private  val  preference = context.getSharedPreferences(PREFERENCE,MODE_PRIVATE)

    fun  isUserSeen():Boolean{
        return preference.getBoolean("SEEN",false)
    }
    fun  saveUserSeen(){
        preference.edit().putBoolean("SEEN",true).apply()
    }
    companion object{

            const val PREFERENCE = "pref.name"
            const val SEEN = "seen.key"
    }
}



