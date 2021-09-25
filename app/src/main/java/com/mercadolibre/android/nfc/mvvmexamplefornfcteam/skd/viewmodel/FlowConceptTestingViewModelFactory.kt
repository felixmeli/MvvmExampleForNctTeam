package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.service.SdkInitializerService

class FlowConceptTestingViewModelFactory(private val sdkInitializerService: SdkInitializerService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        FlowConceptTestingViewModel(sdkInitializerService) as T
}