package com.petnagy.exchangeconverter.pages.model

import com.petnagy.exchangeconverter.network.Endpoint

/***
 * Model class for ConverterActivity.
 */
class ConverterModel(private val endpoint: Endpoint) {

    fun getExchangeRates(baseRate: String) = endpoint.getRates(baseRate)
}
