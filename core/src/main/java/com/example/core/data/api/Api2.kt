package com.example.core.data.api

import com.example.core.data.model.FakeData2
import retrofit2.Response
import retrofit2.http.GET

interface Api2 {
    @GET("fakeEndpoint2")
    suspend fun getDataFromServer2(): Response<FakeData2>
}