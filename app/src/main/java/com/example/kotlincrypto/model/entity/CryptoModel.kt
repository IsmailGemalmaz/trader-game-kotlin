package com.example.kotlincrypto.model.entity

import com.google.gson.annotations.SerializedName

data class CryptoModel(

    @SerializedName("id")
    val id:String?,
    @SerializedName("currency")
    val currency:String?,
    @SerializedName("price")
    val price:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("market_cap")
    val market_cap:String?,
    @SerializedName("rank")
    val rank:String?,
    @SerializedName("circulating_supply")
    val circulating_supply:String,
    @SerializedName("max_supply")
    val max_supply:String,
    @SerializedName("market_cap_dominance")
    val market_cap_dominance:String,
    @SerializedName("high")
    val high:String,
    @SerializedName("high_timestamp")
    val high_timestamp:String,




)