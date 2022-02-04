package com.example.kotlincrypto.model.entity

import com.google.gson.annotations.SerializedName

data class WalletGetModel (
    @SerializedName("currency")
    val currency:String?,
    @SerializedName("amount")
    val amount:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("id")
    val id:Int?
    )