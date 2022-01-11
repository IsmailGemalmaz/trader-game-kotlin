package com.example.kotlincrypto.model

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

)