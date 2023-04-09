package com.geektech.lovecalculator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.lovecalculator.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun  insertLove(loveModel: LoveModel)
    @Query("SELECT * FROM love_table")
    fun getAll():List<LoveModel>
    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun  getAllSort():List<LoveModel>


}