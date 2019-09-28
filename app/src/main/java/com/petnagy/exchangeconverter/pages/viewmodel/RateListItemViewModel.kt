package com.petnagy.exchangeconverter.pages.viewmodel

import com.petnagy.exchangeconverter.R
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.domainobject.Rate

/***
 * ListItemViewModel for Currency Item.
 */
class RateListItemViewModel(private val rate: Rate) : ListItemViewModel() {

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
}
