package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api

import android.util.Log
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.DataPosta
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.service.SdkInitializerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

internal class SdkApi(private val externalScope: CoroutineScope) {

    // Backing property to avoid flow emissions from other classes
    private val _stateFlow = MutableSharedFlow<SdkApiState>(onBufferOverflow = DROP_OLDEST)
    val stateFlow: SharedFlow<SdkApiState> = _stateFlow

    init {
        externalScope.launch {
            sdkInit()
        }
    }

    suspend fun sdkInit() {
        Log.d("SdkApi","El sdk se está inicializando...")
        _stateFlow.emit(SdkApiState.InProgress(PROGRESS_MESSAGE))
        delay(5000)
        _stateFlow.emit(returnSuccess())
        Log.d("SdkApi","Respondió todo OK y entrega la data posta...")
    }

    private fun returnError() =
        SdkApiState.FinishedWithRetryableError(RETRYABLE_ERROR_MESSAGE)

    private fun returnSuccess() =
        SdkApiState.Success(DataPosta(DATA_POSTA))


    companion object {
        const val PROGRESS_MESSAGE = "El sdk se está inicializando"
        const val DATA_POSTA = "¡¡ Ahora sí papá , se inicializó !!"
        const val ERROR_MESSAGE = "¡¡ Aquí todo salió mal !!"
        const val RETRYABLE_ERROR_MESSAGE = "¡¡ Aquí tenemos otra oportunidad !!"
    }
}