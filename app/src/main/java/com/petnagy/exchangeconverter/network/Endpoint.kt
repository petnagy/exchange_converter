package com.petnagy.exchangeconverter.network

import com.petnagy.exchangeconverter.data.apiobject.ApiRateExcahnge
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("/latest")
    fun getRates(@Query("base") base: String): Single<ApiRateExcahnge>
}
