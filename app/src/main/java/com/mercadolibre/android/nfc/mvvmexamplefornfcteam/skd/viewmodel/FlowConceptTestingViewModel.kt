package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.service.SdkInitializerService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowConceptTestingViewModel(private val sdkInitializerService: SdkInitializerService) : ViewModel() {
    private val _stateLiveData = MutableLiveData<String>()
    val stateLiveData: LiveData<String> = _stateLiveData

    init {
        viewModelScope.launch {
            sdkInitializerService.latestState.collect {
                _stateLiveData.value = it
            }
        }
    }
}