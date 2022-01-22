package com.example.kotlincrypto.service

import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.model.entity.WalletPostModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface CryptoApi {

   // https://api.nomics.com/v1/currencies?key=a8a3452e71305947867f9f04df8fd319&ids=BTC,ETH,XRP&convert=eur açıllamlar bilgiler
    //https://api.nomics.com/v1/currencies/ticker?key=a8a3452e71305947867f9f04df8fd319
    @GET
    fun getCrypto(@Url string: String):Observable<List<CryptoModel>>

    @GET
    fun getWallet(@Url string: String):Observable<List<WalletGetModel>>

    @Headers("Content-Type: application/json")
    @POST
    fun addWallet(@Url string: String, @Body walletData: WalletPostModel): Call<WalletPostModel>
}