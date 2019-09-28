package com.petnagy.exchangeconverter.common.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/***
 * ViewHolder for databinding.
 */
class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun getBinding(): ViewDataBinding {
        return binding
    }
}
