package com.petnagy.exchangeconverter.pages.viewmodel

import androidx.lifecycle.*
import com.petnagy.exchangeconverter.common.extensions.default
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.apiobject.ApiRateExcahnge
import com.petnagy.exchangeconverter.data.domainobject.Rate
import com.petnagy.exchangeconverter.pages.model.ConverterModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.math.BigDecimal
import java.util.concurrent.TimeUnit

/***
 * ViewModel for ConverterActivity.
 */
class ConverterViewModel(private val model: ConverterModel) : ViewModel(), LifecycleObserver {

    private lateinit var disposable: Disposable
    val listOfRates =
        MutableLiveData<List<ListItemViewModel>>().default(emptyList<RateListItemViewModel>())

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startPolling() {
        disposable =
            Observable.interval(1, TimeUnit.SECONDS)
                .flatMap { model.getExchangeRates("EUR").toObservable() }
                .map { convertToRateList(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> handleExchangeRates(result) },
                    { error -> handleError(error) })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopPolling() {
        disposePolling()
    }

    private fun handleExchangeRates(result: List<RateListItemViewModel>) {
        Timber.d("Exchange rate arrived success!")
        listOfRates.postValue(result)
    }

    private fun handleError(error: Throwable) {
        Timber.e(error, "Something went wrong during query Exchange rates!!!")
    }

    override fun onCleared() {
        super.onCleared()
        disposePolling()
    }

    private fun disposePolling() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    private fun convertToRateList(apiObject: ApiRateExcahnge): List<RateListItemViewModel> {
        val baseRate = Rate(apiObject.base, BigDecimal.ONE)
        val rateList = apiObject.rates.map { Rate(it.key, it.value) }.toMutableList()
        rateList.add(0, baseRate)
        return rateList.map { RateListItemViewModel(it) }.toList()
    }
}