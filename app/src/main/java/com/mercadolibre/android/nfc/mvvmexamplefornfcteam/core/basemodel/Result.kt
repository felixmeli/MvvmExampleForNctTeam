package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Status.CLIENT_ERROR
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Status.SERVER_ERROR
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Status.SUCCESS
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Status.UNAUTHORIZED
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Status.UNEXPECTED_ERROR

data class Result<out T>(val status: String, val data: T?) {
    companion object {
        fun <T> success(data: T?): Result<T> = Result(SUCCESS, data)
        fun <T> serverError(data: T? = null): Result<T> = Result(SERVER_ERROR, data)
        fun <T> authenticationError(data: T? = null): Result<T> = Result(UNAUTHORIZED, data)
        fun <T> clientError(data: T? = null): Result<T> = Result(CLIENT_ERROR, data)
        fun <T> unexpectedError(data: T? = null): Result<T> = Result(UNEXPECTED_ERROR, data)
    }
}