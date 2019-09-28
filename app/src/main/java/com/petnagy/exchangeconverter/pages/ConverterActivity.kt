package com.petnagy.exchangeconverter.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.petnagy.exchangeconverter.R
import com.petnagy.exchangeconverter.databinding.ActivityMainBinding
import com.petnagy.exchangeconverter.pages.viewmodel.ConverterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ConverterActivity : AppCompatActivity() {

    private val viewModel: ConverterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
    }
}
