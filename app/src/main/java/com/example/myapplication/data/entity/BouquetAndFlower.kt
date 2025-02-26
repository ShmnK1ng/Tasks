package com.example.myapplication.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bouquet_flowers",
    primaryKeys = ["bouquetId", "flowerId"],
    foreignKeys = [
        ForeignKey(
            entity = Bouquet::class,
            parentColumns = ["bouquetId"],
            childColumns = ["bouquetId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Flower::class,
            parentColumns = ["flowerId"],
            childColumns = ["flowerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BouquetAndFlower(
    val bouquetId: Int,
    val flowerId: Int,
    val count: Int
)