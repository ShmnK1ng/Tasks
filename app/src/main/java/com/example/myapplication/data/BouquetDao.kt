package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.data.entity.Bouquet
import com.example.myapplication.data.entity.BouquetWithFlowers

@Dao
interface BouquetDao {
    @Query("SELECT * FROM bouquets")
    fun getAllBouquets(): List<Bouquet>

    @Delete
    fun deleteBouquet(bouquet: Bouquet)

    @Transaction
    @Query("SELECT * FROM bouquets WHERE bouquetId = :bouquetId")
    fun getBouquetWithFlowers(bouquetId: Int): BouquetWithFlowers

    @Query("SELECT count FROM bouquet_flowers WHERE bouquetId = :bouquetId AND flowerId = :flowerId")
    fun getCountForFlowerInBouquet(bouquetId: Int, flowerId: Int): Int
}