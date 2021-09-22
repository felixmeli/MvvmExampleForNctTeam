package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.service

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.model.Model
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Service {

    suspend fun getData() : Model = withContext(IO) {
        delay(5000)
        Model()
    }

}