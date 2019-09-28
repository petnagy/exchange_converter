package com.petnagy.exchangeconverter.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.petnagy.exchangeconverter.network.Endpoint
import com.petnagy.exchangeconverter.pages.model.ConverterModel
import com.petnagy.exchangeconverter.pages.viewmodel.ConverterViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://revolut.duckdns.org"
private const val TIME_OUT_IN_SEC: Long = 60

val applicationModule = module {

}

val modelModules = module {
    factory { ConverterModel(get()) }
}

val viewModelModules = module {
    viewModel { ConverterViewModel(get()) }
}

val networkModule = module {
    single {
        GsonBuilder().serializeNulls()
            .create()
    }
    single { createBaseOkHttpBuilder().build() }
    single { createRetrofit(get(), get()) }
    single { createEndpoint(get()) }
}

fun createBaseOkHttpBuilder(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT_IN_SEC, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_IN_SEC, TimeUnit.SECONDS)
}

fun createRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}

fun createEndpoint(retrofit: Retrofit): Endpoint = retrofit.create(Endpoint::class.java)