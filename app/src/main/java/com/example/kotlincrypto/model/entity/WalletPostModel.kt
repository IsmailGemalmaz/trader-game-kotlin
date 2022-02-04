package com.example.kotlincrypto.model.entity

import com.google.gson.annotations.SerializedName

data class WalletPostModel (
    @SerializedName("userId")
    val userId:Int?,
    @SerializedName("currency")
    val currency:String?,
     @SerializedName("amount")
    val amount:String?
)