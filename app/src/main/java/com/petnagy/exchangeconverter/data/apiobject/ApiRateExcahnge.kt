package com.petnagy.exchangeconverter.data.apiobject

import java.math.BigDecimal
import kotlin.collections.LinkedHashMap

/***
 * Data object come from endpoint.
 */
data class ApiRateExcahnge(val base: String, val date: String, val rates: LinkedHashMap<String, BigDecimal>)