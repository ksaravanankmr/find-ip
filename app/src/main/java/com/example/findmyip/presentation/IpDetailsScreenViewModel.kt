package com.example.findmyip.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.findmyip.domain.IpRepository
import com.example.findmyip.domain.model.Resource
import kotlinx.coroutines.launch

class IpDetailsScreenViewModel(private val repository: IpRepository) : ViewModel() {

    var state by mutableStateOf(IpDetailsScreenUiState())
        private set

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            state = state.copy(ipAddress = Resource.Loading())
            val result = repository.getIpAddress()
            state = state.copy(ipAddress = result)
        }
    }
}

class IpDetailsScreenViewModelFactory(private val repository: IpRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IpDetailsScreenViewModel::class.java)) {
            return IpDetailsScreenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel")
    }
}