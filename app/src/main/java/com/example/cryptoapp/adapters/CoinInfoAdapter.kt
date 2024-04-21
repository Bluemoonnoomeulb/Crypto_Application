package com.example.cryptoapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter : Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    var coinInfoList: List<CoinPriceInfo> = listOf()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CoinInfoViewHolder(binding)
    }

    override fun getItemCount() = coinInfoList.size

    //@SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder){
            with(coin) {
                priceCoin.text = price.toString()
                lastUpdateCoin.text = getFormattedTime()
                currencyCoin.text = "$fromSymbol / $toSymbol"
                Picasso.get().load(getFullImageUrl()).into(logoCoin)
            }
        }
    }

    inner class CoinInfoViewHolder(binding: ItemCoinInfoBinding) : ViewHolder(binding.root) {
        val logoCoin = binding.logo
        val currencyCoin = binding.currency
        val priceCoin = binding.price
        val lastUpdateCoin = binding.lastUpdateTime
    }
}