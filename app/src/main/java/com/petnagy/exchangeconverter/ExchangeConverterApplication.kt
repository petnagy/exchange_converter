package com.petnagy.exchangeconverter

import android.app.Application
import com.petnagy.exchangeconverter.di.applicationModule
import com.petnagy.exchangeconverter.di.modelModules
import com.petnagy.exchangeconverter.di.networkModule
import com.petnagy.exchangeconverter.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/***
 * Main Application to init all things here.
 */
class ExchangeConverterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ExchangeConverterApplication)
            androidFileProperties()
            modules(
                listOf(
                    applicationModule,
                    networkModule,
                    modelModules,
                    viewModelModules
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
