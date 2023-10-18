package com.example.findmyip.data.repository

import com.example.findmyip.data.mapper.toIpAddress
import com.example.findmyip.data.remote.RetrofitInstance
import com.example.findmyip.domain.IpRepository
import com.example.findmyip.domain.model.IpAddress
import com.example.findmyip.domain.model.Resource
import java.io.IOException
import java.net.SocketTimeoutException

class IpRepositoryImpl : IpRepository {

    private val ipApi = RetrofitInstance.ipApi

    override suspend fun getIpAddress(): Resource<IpAddress> {
        return try {
            val result = ipApi.getIpAddress()
            if (result.isSuccessful) {
                Resource.Success(data = result.body()?.toIpAddress())
            } else {
                Resource.Error(message = "Api exception: ${result.errorBody()?.string()}")
            }
        } catch (e: SocketTimeoutException) {
            Resource.Error(message = "Timeout exception")
        } catch (e: IOException) {
            Resource.Error(message = "Please check your network connection")
        } catch (e: Exception) {
            Resource.Error(message = "Unknown error")
        }
    }
}