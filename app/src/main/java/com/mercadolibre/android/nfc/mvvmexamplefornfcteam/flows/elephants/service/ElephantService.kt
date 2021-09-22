package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.service

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.model.ElephantModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.http.Body

class ElephantService {

    fun getData() : Response<ElephantModel> = Response.error(404, "".toResponseBody("application/json, charset=utf8".toMediaType()))

}