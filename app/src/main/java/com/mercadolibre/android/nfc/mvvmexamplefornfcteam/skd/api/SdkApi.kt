package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api

import android.util.Log
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.DataPosta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SdkApi private constructor(private val externalScope: CoroutineScope) {

    // Backing property to avoid flow emissions from other classes
    private val _stateFlow = MutableStateFlow<SdkApiState>(SdkApiState.InProgress(PROGRESS_MESSAGE))
    val stateFlow: StateFlow<SdkApiState> = _stateFlow

    init {
        sdkInit()
    }

    fun sdkInit() = externalScope.launch {
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

        // For Singleton instantiation
        @Volatile private var instance: SdkApi? = null

        fun getInstance(externalScope: CoroutineScope) =
            instance ?: synchronized(this) {
                instance ?: SdkApi(externalScope).also { instance = it }
            }
    }
}