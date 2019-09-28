package com.petnagy.exchangeconverter.data.domainobject

import java.math.BigDecimal

/***
 * Domain object for Rate
 */
data class Rate(val currency: String, val rate: BigDecimal)