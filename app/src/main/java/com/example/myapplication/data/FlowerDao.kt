package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Update
import com.example.myapplication.data.entity.Flower

@Dao
interface FlowerDao {
    @Update
    fun updateFlower(flower: Flower)

    @Delete
    fun deleteFlower(flower: Flower)
}