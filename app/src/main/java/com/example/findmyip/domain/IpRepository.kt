package com.example.findmyip.domain

import com.example.findmyip.domain.model.IpAddress
import com.example.findmyip.domain.model.Resource

interface IpRepository {

    suspend fun getIpAddress(): Resource<IpAddress>

}