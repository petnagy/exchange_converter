package com.petnagy.exchangeconverter.pages.viewmodel

import android.view.View
import com.petnagy.exchangeconverter.R
import com.petnagy.exchangeconverter.common.recyclerview.ListItemViewModel
import com.petnagy.exchangeconverter.data.domainobject.Rate
import java.text.DecimalFormat

/***
 * ListItemViewModel for Currency Item.
 */
class RateListItemViewModel(
    val rate: Rate,
    private val callback: OnCurrencyClickedListener
) : ListItemViewModel() {

    companion object {
        val formatter = DecimalFormat("###,###.##")
    }

    val flag = rate.currency.flagResId
    val currency = rate.currency.name
    val nameOfCurrency = rate.currency.currencyName
    val numberOfRate: String = formatter.format(rate.rate)

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
