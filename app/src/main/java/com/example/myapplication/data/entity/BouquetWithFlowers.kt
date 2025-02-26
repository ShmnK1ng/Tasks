package com.example.myapplication.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BouquetWithFlowers(
    @Embedded val bouquet: Bouquet,
    @Relation(
        parentColumn = "bouquetId",
        entityColumn = "flowerId",
        associateBy = Junction(BouquetAndFlower::class)
    )
    val flowers: List<Flower>
)