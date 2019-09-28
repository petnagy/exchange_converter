package com.petnagy.exchangeconverter.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("image")
    fun bindImage(imageView: ImageView, imageResId: Int) {
        imageView.setImageResource(imageResId)
    }
}