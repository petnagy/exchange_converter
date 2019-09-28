package com.petnagy.exchangeconverter.pages.viewmodel

import android.view.View
import com.petnagy.exchangeconverter.R
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.domainobject.Rate

/***
 * ListItemViewModel for Currency Item.
 */
class RateListItemViewModel(
    private val rate: Rate,
    private val callback: OnCurrencyClickedListener
) : ListItemViewModel() {

    val flag = rate.currency.flagResId
    val currency = rate.currency.name
    val nameOfCurrency = rate.currency.currencyName
    val numberOfRate = rate.rate.toString()

    override fun getViewType() = R.layout.list_item_rate

    override fun areItemsTheSame(newItem: ListItemViewModel) =
        isSame(newItem as RateListItemViewModel)

    override fun areContentsTheSame(newItem: ListItemViewModel) =
        isSame(newItem as RateListItemViewModel)

    private fun isSame(other: RateListItemViewModel) = this.rate.currency == other.rate.currency

    fun onRowClicked(view: View) {
        callback.onCurrencySelected(rate.currency, rate.rate)
    }
}
