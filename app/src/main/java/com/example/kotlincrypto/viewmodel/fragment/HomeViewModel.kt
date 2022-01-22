package com.example.kotlincrypto.viewmodel.fragment

import android.app.Application
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.service.CryptoApiService
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(application: Application):BaseViewModel(application) {

    private val disposable= CompositeDisposable()
    private val cryptoApiService= CryptoApiService()
    private var cryptoModels: ArrayList<CryptoModel>? = null
}