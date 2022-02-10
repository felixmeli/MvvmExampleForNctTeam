package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.skd

import kotlinx.coroutines.*

class Cancelacion (
    private var scope: CoroutineScope = CoroutineScope(Job() + Dispatchers.IO)
){

    fun confing() = scope.launch {
        repeat(10) { i->
            println( "epreando $i" )
            delay(1000L)
        }
        println( "epreando ${scope.isActive}" )
        scope.cancel()
        println( "epreando ${scope.isActive}" )
    }
}