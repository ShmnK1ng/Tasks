package com.example.feature.home

import com.example.core.data.api.Api1
import com.example.core.data.api.Api2
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api1: Api1,
    private val api2: Api2
): HomeRepository {

    override suspend fun loadDataFromTwoServers() {
        val result1 = api1.getDataFromServer1()
        val result2 = api2.getDataFromServer2()

        println("Result1 = $result1, Result2 = $result2")
    }
}

interface HomeRepository {
    suspend fun loadDataFromTwoServers()
}