package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.service

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api.SdkApi
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api.SdkApiState
import kotlinx.coroutines.flow.*

class SdkInitializerService(private val sdkApi: SdkApi) {

    val latestState =
        sdkApi.stateFlow.flatMapConcat<SdkApiState, String> { sdkApiState ->
            when(sdkApiState) {

                is SdkApiState.InProgress -> flow { emit(SdkInitializerState.INITIALIZING) }

                is SdkApiState.Success -> flow { emit(SdkInitializerState.FINISHED_SUCCESSFULLY) }

                is SdkApiState.FinishedWithException -> flow { emit(SdkInitializerState.FINISHED_WITH_ERROR) }

                is SdkApiState.FinishedWithRetryableError -> flow {
                    sdkApi.sdkInit()
                    emit(SdkInitializerState.INITIALIZING)
                }
            }
        }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: SdkInitializerService? = null

        fun getInstance(sdkApi: SdkApi) =
            instance ?: synchronized(this) {
                instance ?: SdkInitializerService(sdkApi).also { instance = it }
            }
    }
}