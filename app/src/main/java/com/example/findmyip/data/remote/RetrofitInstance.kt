package com.example.findmyip.data.remote

import com.example.findmyip.data.remote.api.IpApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://ipapi.co/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val ipApi: IpApi by lazy {
        retrofit.create(IpApi::class.java)
    }
}