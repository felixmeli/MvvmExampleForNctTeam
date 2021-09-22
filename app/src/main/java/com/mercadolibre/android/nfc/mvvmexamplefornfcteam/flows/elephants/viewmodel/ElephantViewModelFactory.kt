package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.repository.ElephantRepository


class ElephantViewModelFactory(private val elephantRepository: ElephantRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ElephantViewModel(elephantRepository) as T
}