package com.example.kotlincrypto.model.entity

import com.google.gson.annotations.SerializedName

data class LoginModel (
    @SerializedName("email")
    var email:String?,
    @SerializedName("password")
    var password:String?,
    @SerializedName("err")
    var error:Boolean?=null,
    @SerializedName("errStatment")
    var errStatment:String?=null,
    @SerializedName("id")
    var userId:Int?=null,
    @SerializedName("token")
    var jwtToken:String?=null,

)