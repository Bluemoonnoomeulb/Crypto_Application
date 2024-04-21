package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityCoinDetailBinding
import com.squareup.picasso.Picasso

class CoinDetailsActivity: AppCompatActivity() {


    private lateinit var viewModel: CoinViewModel
    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }

        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: ""

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailsInfo(fromSymbol).observe(this) {
            Picasso.get().load(it.getFullImageUrl()).into(binding.logoLarge)
            binding.coinName.text = it.fromSymbol
            binding.currency.text = it.toSymbol
            binding.maxCurrency.text = it.toSymbol
            binding.minCurrency.text = it.toSymbol
            binding.currentPrice.text = it.price.toString()
            binding.minPrice.text = it.lowDay
            binding.maxPrice.text = it.highDay
            binding.dealMarket.text = it.lastMarket

            val lastUpdateTemplate = this.resources.getString(R.string.update_time)
            binding.updateTime.text = String.format(lastUpdateTemplate, it.getFormattedTime())
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailsActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}