package com.petnagy.exchangeconverter.data

import com.petnagy.exchangeconverter.R

enum class Currency(val flagResId: Int, val currencyName: Int, val visible: Boolean) {

    AUD(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    BGN(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    BRL(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    CAD(R.drawable.ic_canada, R.string.CAD, true),
    CHF(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    CNY(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    CZK(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    DKK(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    GBP(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    HKD(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    HRK(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    HUF(R.drawable.ic_unkonw_flag, R.string.HUF, false),
    IDR(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    ILS(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    INR(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    ISK(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    JPY(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    KRW(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    MXN(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    MYR(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    NOK(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    NZD(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    PHP(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    PLN(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    RON(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    RUB(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    SEK(R.drawable.ic_sweden, R.string.SEK, true),
    SGD(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    THB(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    TRY(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    USD(R.drawable.ic_us, R.string.USD, true),
    ZAR(R.drawable.ic_unkonw_flag, R.string.no_name, false),
    EUR(R.drawable.ic_eu, R.string.EUR, true)
}