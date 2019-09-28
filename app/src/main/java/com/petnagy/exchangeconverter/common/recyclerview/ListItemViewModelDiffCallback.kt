package com.petnagy.exchangeconverter.common.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel

/***
 * DiffUtil's callback to handle changes.
 */
class ListItemViewModelDiffCallback(
    private val oldItems: List<ListItemViewModel>,
    private val newItems: List<ListItemViewModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].areItemsTheSame(newItems[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].areContentsTheSame(newItems[newItemPosition])
    }
}
