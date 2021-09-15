package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.deserializer

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result.Companion.authenticationError
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result.Companion.clientError
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result.Companion.serverError
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result.Companion.success
import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.basemodel.Result.Companion.unexpectedError
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK
import java.net.HttpURLConnection.HTTP_PARTIAL
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_UNSUPPORTED_TYPE
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_VERSION

object WrapperResponse {

    inline fun <reified T : Any> mapResponse(response:Response<T>) : Result<T> {

        return when (response.code()) {
            in HTTP_OK..HTTP_PARTIAL -> {
                success(response.body())
            }
            HTTP_UNAUTHORIZED -> {
                authenticationError()
            }
            in HTTP_BAD_REQUEST..HTTP_UNSUPPORTED_TYPE -> {
                clientError()
            }
            in HTTP_INTERNAL_ERROR..HTTP_VERSION -> {
                serverError()
            }
            else -> {
                unexpectedError()
            }
        }

    }

}