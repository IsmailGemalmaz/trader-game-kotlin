package com.example.kotlincrypto.service

import com.example.kotlincrypto.model.CryptoModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CryptoApiService {

    private val BASE_URL="https://api.nomics.com/v1/"
    private val api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CryptoApi::class.java)

    fun getData(): Observable<List<CryptoModel>> {
        return api.getCrypto()
    }
}