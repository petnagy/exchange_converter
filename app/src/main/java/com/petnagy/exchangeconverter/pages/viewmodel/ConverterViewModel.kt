package com.petnagy.exchangeconverter.pages.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.*
import com.petnagy.exchangeconverter.common.extensions.default
import com.petnagy.exchangeconverter.common.extensions.safeValue
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.Currency
import com.petnagy.exchangeconverter.data.apiobject.ApiRateExcahnge
import com.petnagy.exchangeconverter.data.domainobject.Rate
import com.petnagy.exchangeconverter.pages.model.ConverterModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.concurrent.TimeUnit

/***
 * ViewModel for ConverterActivity.
 */
class ConverterViewModel(private val model: ConverterModel) : ViewModel(), LifecycleObserver,
    OnCurrencyClickedListener {

    private lateinit var disposable: Disposable
    val listOfRates =
        MutableLiveData<List<ListItemViewModel>>().default(emptyList<RateListItemViewModel>())

    val baseFlag = MutableLiveData<Int>().default(Currency.EUR.flagResId)
    val baseCurrency = MutableLiveData<String>().default(Currency.EUR.name)
    val nameOfBaseCurrency = MutableLiveData<Int>().default(Currency.EUR.currencyName)
    val baseRate = MutableLiveData<String>().default(BigDecimal.ONE.toString())

    private var actualCurrency = Currency.EUR
    private var baseAmount = BigDecimal.ONE
    private val formatter = DecimalFormat("###,###.##")

    val amountChange = object:  TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            val text = editable?.toString() ?: ""
            val clearedText = text.replace(",", "")
            val amountText = if (clearedText.isEmpty()) "0" else clearedText
            baseAmount = BigDecimal(amountText)
            baseRate.value = formatter.format(baseAmount)

            model.getExchangeRates(actualCurrency.name)
                .map { convertToRateList(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> handleExchangeRates(result) },
                    { error -> handleError(error) })
        }

        override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
            // not implemented
        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            // not implemented
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startPolling() {
        disposable =
            Observable.interval(1, TimeUnit.SECONDS)
                .flatMap { model.getExchangeRates(actualCurrency.name).toObservable() }
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
        return apiObject.rates.filter { it.key.visible }
            .map { Rate(it.key, it.value.multiply(baseAmount)) }
            .map { RateListItemViewModel(it, this) }
            .toList()
    }

    override fun onCurrencySelected(currency: Currency, amount: BigDecimal) {
        baseFlag.value = currency.flagResId
        baseCurrency.value = currency.name
        nameOfBaseCurrency.value = currency.currencyName
        baseRate.value = formatter.format(amount)

        val list = listOfRates.safeValue(emptyList())
            .filter { (it as RateListItemViewModel).currency != currency.name }.toMutableList()
        list.add(RateListItemViewModel(Rate(currency, amount), this))
        list.sortWith(compareBy { (it as RateListItemViewModel).rate.currency.ordinal })
        listOfRates.value = list

        actualCurrency = currency
        baseAmount = amount
    }
}

interface OnCurrencyClickedListener {
    fun onCurrencySelected(currency: Currency, amount: BigDecimal)
}