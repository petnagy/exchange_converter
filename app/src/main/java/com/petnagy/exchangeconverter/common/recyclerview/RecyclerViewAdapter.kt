package com.petnagy.exchangeconverter.common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.petnagy.exchangeconverter.BR

/***
 * General RecyclerView Adapter.
 */
class RecyclerViewAdapter :
    androidx.recyclerview.widget.RecyclerView.Adapter<BindableViewHolder>() {

    var items: MutableList<ListItemViewModel> = ArrayList()
        set(value) {
            oldItems = ArrayList(items)
            this.items.clear()
            this.items.addAll(value)
            val diffResult = DiffUtil.calculateDiff(ListItemViewModelDiffCallback(oldItems, items))
            diffResult.dispatchUpdatesTo(this)
        }

    private var oldItems: ArrayList<ListItemViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val dataBinding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return BindableViewHolder(dataBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.getBinding().setVariable(BR.viewModel, items[position])
        holder.getBinding().executePendingBindings()
    }

    override fun onBindViewHolder(
        holder: BindableViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        }
    }
}
