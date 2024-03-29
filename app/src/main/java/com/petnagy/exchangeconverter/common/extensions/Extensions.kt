package com.petnagy.exchangeconverter.common.extensions

import androidx.lifecycle.MutableLiveData

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun <T> MutableLiveData<T>.safeValue(default: T): T = value ?: default