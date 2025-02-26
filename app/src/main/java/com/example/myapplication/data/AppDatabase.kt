package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.entity.Bouquet
import com.example.myapplication.data.entity.BouquetAndFlower
import com.example.myapplication.data.entity.Flower

@Database(
    entities = [
        Flower::class,
        Bouquet::class,
        BouquetAndFlower::class
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "flower_shop_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}