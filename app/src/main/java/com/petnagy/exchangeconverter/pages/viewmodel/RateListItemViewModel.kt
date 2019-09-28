package com.petnagy.exchangeconverter.pages.viewmodel

import com.petnagy.exchangeconverter.R
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.domainobject.Rate

/***
 * ListItemViewModel for Rate Item.
 */
class RateListItemViewModel(rate: Rate) : ListItemViewModel() {

    val currency = rate.currency
    val numberOfRate = rate.rate.toString()

    override fun getViewType() = R.layout.list_item_rate

    override fun areItemsTheSame(newItem: ListItemViewModel) = false

    override fun areContentsTheSame(newItem: ListItemViewModel) = false
}
