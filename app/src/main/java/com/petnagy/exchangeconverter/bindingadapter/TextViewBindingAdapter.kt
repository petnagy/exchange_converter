package com.petnagy.exchangeconverter.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("text")
    fun bindText(textView: TextView, textResId: Int) {
        textView.setText(textResId)
    }
}