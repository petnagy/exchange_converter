package com.petnagy.exchangeconverter.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.common.recyclerview.RecyclerViewAdapter

object RecyclerViewBindingAdapter {
    @BindingAdapter("source")
    @JvmStatic
    fun setupRecyclerView(recyclerView: RecyclerView, source: List<ListItemViewModel>) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        var adapter = recyclerView.adapter
        if (adapter == null) {
            adapter = RecyclerViewAdapter()
        }
        adapter as RecyclerViewAdapter
        adapter.items = source.toMutableList()
        recyclerView.adapter = adapter
    }
}