package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_coin_price_info")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    val market: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String? = null,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,

    @SerializedName("MEDIAN")
    @Expose
    val median: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24Hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: Double? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Int? = null,

    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String? = null
)