package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.repository

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.deserializer.WrapperResponse
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.service.ElephantService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ElephantRepository(private val service: ElephantService) {
    suspend fun getElephantModel() = withContext(IO) {
        delay(2000)
        return@withContext WrapperResponse.mapResponse(service.getData())
    }
}