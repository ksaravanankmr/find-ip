package com.example.findmyip.presentation

import com.example.findmyip.domain.model.IpAddress
import com.example.findmyip.domain.model.Resource

data class IpDetailsScreenUiState(val ipAddress: Resource<IpAddress> = Resource.Loading())