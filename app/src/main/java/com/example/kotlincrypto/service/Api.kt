package com.example.kotlincrypto.service

import com.example.kotlincrypto.model.entity.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface Api {

   // https://api.nomics.com/v1/currencies?key=a8a3452e71305947867f9f04df8fd319&ids=BTC,ETH,XRP&convert=eur açıllamlar bilgiler
    //https://api.nomics.com/v1/currencies/ticker?key=a8a3452e71305947867f9f04df8fd319
    @GET
    fun getCrypto(@Url url: String):Observable<List<CryptoModel>>

    @GET
    fun getWallet(@Url url: String):Observable<List<WalletGetModel>>

    @Headers("Content-Type: application/json")
    @POST
    fun addWallet(@Url url: String, @Body walletData: WalletPostModel): Call<WalletPostModel>

   @Headers("Content-Type: application/json")
   @POST
   fun loginUser(@Url url: String, @Body loginModel: LoginModel): Call<LoginModel>


   @Headers("Content-Type: application/json")
   @PUT
   fun sellWallet(@Url url: String, @Body walletData: WalletSellModel): Call<WalletSellModel>
}