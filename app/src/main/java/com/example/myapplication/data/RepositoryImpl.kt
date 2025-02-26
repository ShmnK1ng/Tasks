package com.example.myapplication.data

import com.example.myapplication.data.entity.Bouquet

class RepositoryImpl(
    private val database: AppDatabase
) : Repository {

    private val flowerDao = database.flowerDao()
    private val bouquetDao = database.bouquetDao()

    override fun getAllBouquets(): List<Bouquet> = bouquetDao.getAllBouquets()

    override fun purchaseBouquet(bouquetId: Int) {
        database.runInTransaction {
            val bouquetWithFlowers = bouquetDao.getBouquetWithFlowers(bouquetId)
            bouquetWithFlowers.flowers.forEach { flower ->
                val requiredCount = bouquetDao.getCountForFlowerInBouquet(bouquetId, flower.flowerId)
                val newQuantity = flower.quantity - requiredCount
                if (newQuantity > 0) {
                    flowerDao.updateFlower(flower.copy(quantity = newQuantity))
                } else {
                    flowerDao.deleteFlower(flower)
                }
            }
            bouquetDao.deleteBouquet(bouquetWithFlowers.bouquet)
        }
    }
}

interface Repository {
    fun getAllBouquets(): List<Bouquet>
    fun purchaseBouquet(bouquetId: Int)
}