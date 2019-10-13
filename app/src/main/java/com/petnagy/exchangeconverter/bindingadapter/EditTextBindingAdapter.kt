package com.petnagy.exchangeconverter.bindingadapter

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

object EditTextBindingAdapter {

    @JvmStatic
    @BindingAdapter("onTextChange")
    fun setupTextChange(editText: EditText, textChange: TextWatcher) {
        editText.addTextChangedListener(textChange)
    }
}
