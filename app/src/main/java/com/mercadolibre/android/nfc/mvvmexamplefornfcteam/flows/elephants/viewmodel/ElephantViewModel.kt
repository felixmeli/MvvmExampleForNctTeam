package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.viewmodel

import androidx.lifecycle.viewModelScope
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.base.BaseViewModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.model.ElephantModel
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.repository.ElephantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ElephantViewModel(private val elephantRepository: ElephantRepository): BaseViewModel<ElephantModel>() {

    fun getElephantModel() = viewModelScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
        isLoading.postValue(true)
        manageResponseStatus(elephantRepository.getElephantModel())
    }
}