package com.petnagy.exchangeconverter.data

import com.petnagy.exchangeconverter.R

enum class Currency(val flagResId: Int, val currencyName: Int, val visible: Boolean) {

    AUD(R.drawable.ic_australian_flag, R.string.AUD, false),
    BGN(R.drawable.ic_bulgaria, R.string.BGN, false),
    BRL(R.drawable.ic_brazil, R.string.BRL, true),
    CAD(R.drawable.ic_canada, R.string.CAD, true),
    CHF(R.drawable.ic_switzeland, R.string.CHF, false),
    CNY(R.drawable.ic_china, R.string.CNY, false),
    CZK(R.drawable.ic_czech_republic, R.string.CZK, false),
    DKK(R.drawable.ic_unkonw_flag, R.string.DKK, false),
    GBP(R.drawable.ic_united_kingdom, R.string.GBP, true),
    HKD(R.drawable.ic_hongkong, R.string.HKD, false),
    HRK(R.drawable.ic_unkonw_flag, R.string.HRK, false),
    HUF(R.drawable.ic_hungaria, R.string.HUF, true),
    IDR(R.drawable.ic_unkonw_flag, R.string.IDR, false),
    ILS(R.drawable.ic_unkonw_flag, R.string.ILS, false),
    INR(R.drawable.ic_unkonw_flag, R.string.INR, false),
    ISK(R.drawable.ic_unkonw_flag, R.string.ISK, false),
    JPY(R.drawable.ic_japan, R.string.JPY, false),
    KRW(R.drawable.ic_unkonw_flag, R.string.KRW, false),
    MXN(R.drawable.ic_mexico, R.string.MXN, false),
    MYR(R.drawable.ic_unkonw_flag, R.string.MYR, false),
    NOK(R.drawable.ic_unkonw_flag, R.string.NOK, false),
    NZD(R.drawable.ic_unkonw_flag, R.string.NZD, false),
    PHP(R.drawable.ic_unkonw_flag, R.string.PHP, false),
    PLN(R.drawable.ic_unkonw_flag, R.string.PLN, false),
    RON(R.drawable.ic_unkonw_flag, R.string.RON, false),
    RUB(R.drawable.ic_unkonw_flag, R.string.RUB, false),
    SEK(R.drawable.ic_sweden, R.string.SEK, true),
    SGD(R.drawable.ic_unkonw_flag, R.string.SGD, false),
    THB(R.drawable.ic_unkonw_flag, R.string.THB, false),
    TRY(R.drawable.ic_unkonw_flag, R.string.TRY, false),
    USD(R.drawable.ic_us, R.string.USD, true),
    ZAR(R.drawable.ic_unkonw_flag, R.string.ZAR, false),
    EUR(R.drawable.ic_eu, R.string.EUR, true)
}