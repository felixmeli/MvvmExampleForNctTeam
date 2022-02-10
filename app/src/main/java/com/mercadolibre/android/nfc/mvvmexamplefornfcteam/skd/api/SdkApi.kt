package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api

import android.util.Log
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.DataPosta
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SdkApi private constructor() {

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    // Backing property to avoid flow emissions from other classes
    private val _stateFlow = MutableStateFlow<SdkApiState>(SdkApiState.InProgress(PROGRESS_MESSAGE))
    val stateFlow: StateFlow<SdkApiState> = _stateFlow

    init {
        sdkInit()
    }

    fun sdkInit() = scope.launch {

        Log.i("SdkApi", "El sdk se está verificando...${Thread.currentThread()}")
        if (stateFlow.value is SdkApiState.Success) cleanUp()

        Log.i("SdkApi", "El sdk se está inicializando...${Thread.currentThread()}")
        _stateFlow.emit(SdkApiState.InProgress(PROGRESS_MESSAGE))
        delay(10000)

        Log.i("SdkApi", "esperando por la push...${Thread.currentThread()}")
        _stateFlow.emit(SdkApiState.WatingForPush)
        delay(10000)

        cleanUp()
    }

    private fun returnError() =
        SdkApiState.FinishedWithRetryableError(RETRYABLE_ERROR_MESSAGE)

    private fun returnSuccess() =
        SdkApiState.Success(DataPosta(DATA_POSTA))

    fun cleanUp() {
        // Cancel the scope to cancel ongoing coroutines work
        scope.cancel()
    }

    companion object {
        const val PROGRESS_MESSAGE = "El sdk se está inicializando"
        const val DATA_POSTA = "¡¡ Ahora sí papá , se inicializó !!"
        const val ERROR_MESSAGE = "¡¡ Aquí todo salió mal !!"
        const val RETRYABLE_ERROR_MESSAGE = "¡¡ Aquí tenemos otra oportunidad !!"

        // For Singleton instantiation
        @Volatile private var instance: SdkApi? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: SdkApi().also { instance = it }
            }
    }
}