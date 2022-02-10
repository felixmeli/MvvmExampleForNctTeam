package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.api

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd.DataPosta

sealed class SdkApiState {
    class Success(val dataPosta: DataPosta): SdkApiState()
    data class InProgress(val message:String): SdkApiState()
    object WatingForPush : SdkApiState()
    class FinishedWithRetryableError(val error:String): SdkApiState()
    data class FinishedWithException(val exception: Throwable): SdkApiState()
}
