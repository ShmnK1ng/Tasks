package com.example.core.data.api
import com.example.core.data.model.FakeData1
import retrofit2.Response
import retrofit2.http.GET

interface Api1 {
    @GET("fakeEndpoint1")
    suspend fun getDataFromServer1(): Response<FakeData1>
}