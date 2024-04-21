package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.utils.convertTimestampToTime
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.rxjava3.annotations.NonNull

@Entity(tableName = "full_coin_price_info")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    val market: String? = null,

    @NonNull
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: String?,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: String?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,

    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String? = null
) {
    fun getFormattedTime(): String = convertTimestampToTime(lastUpdate)

    fun getFullImageUrl(): String = BASE_IMAGE_URL + imageUrl
}