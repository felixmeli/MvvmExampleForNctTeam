package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.cancelation

import kotlinx.coroutines.*

class CancellationExample {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun configure() = scope.launch {
        try {
            repeat(10) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }

            delay(1300L) // delay a bit
            println("main: I'm tired of waiting!")
        } finally {

            println("main: Listo")
            println("está activo el scope?: ${scope.isActive}")
            scope.cancel() // cancels the job

            println("está activo el scope?: ${scope.isActive}")
        }

    }

}