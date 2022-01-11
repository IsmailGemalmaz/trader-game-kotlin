package com.example.kotlincrypto.service

import com.example.kotlincrypto.constant.ApiEndpoint
import com.example.kotlincrypto.model.CryptoModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface CryptoApi {
    //https://api.nomics.com/v1/currencies/ticker?key=a8a3452e71305947867f9f04df8fd319
    @GET("currencies/ticker?key=a8a3452e71305947867f9f04df8fd319")
    fun getCrypto(): Observable<List<CryptoModel>>
}