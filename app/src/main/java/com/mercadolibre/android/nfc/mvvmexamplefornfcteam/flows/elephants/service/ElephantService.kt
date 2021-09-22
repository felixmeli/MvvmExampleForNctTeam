package com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.service

import com.mercadolibre.android.nfc.mvvmexamplefornfcteam.flows.elephants.model.ElephantModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Response

class ElephantService {

    fun getData() : Response<ElephantModel> = Response.success(ElephantModel())
//    fun getData() : Response<ElephantModel> = Response.error(404, "".toResponseBody("application/json, charset=utf8".toMediaType()))

}