package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.core.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private const val BASE_URL = "https://api.mercadolibre.com/"
    private const val TIME_OUT = 6000L

    private val logInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logInterceptor)
        .addInterceptor(HeaderInterceptor())
        .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
        .build()


    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}