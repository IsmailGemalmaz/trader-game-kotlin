package com.example.kotlincrypto.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {


    fun apiPostBuild(string: String):Retrofit{
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(string) // change this IP for testing by your actual machine IP
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }


    fun<T> buildService(service: Class<T>,string: String): T{
        return apiPostBuild(string).create(service)
    }


    fun apiGetBuild(string:String):Api{
        val nomicsApi= Retrofit.Builder()
            .baseUrl(string)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Api::class.java)
        return nomicsApi
    }
}