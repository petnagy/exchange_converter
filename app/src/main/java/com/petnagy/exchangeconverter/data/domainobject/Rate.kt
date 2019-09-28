package com.petnagy.exchangeconverter.data.domainobject

import com.petnagy.exchangeconverter.data.Currency
import java.math.BigDecimal

/***
 * Domain object for Currency
 */
data class Rate(val currency: Currency, val rate: BigDecimal)