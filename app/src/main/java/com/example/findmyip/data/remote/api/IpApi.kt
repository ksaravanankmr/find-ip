package com.example.findmyip.data.remote.api

import com.example.findmyip.data.remote.dto.IpAddressDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface IpApi {
    @GET("json/")
    suspend fun getIpAddress(@Header("User-Agent") string: String = "FindMyIP App"): Response<IpAddressDto>
}