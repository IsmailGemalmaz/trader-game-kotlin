package com.example.kotlincrypto.viewmodel.activity

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.service.ApiService
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class CryptoDetailViewModel(application: Application):BaseViewModel(application) {

    private var cryptoModels: ArrayList<CryptoModel>? = null
    private val disposable= CompositeDisposable()
    private val cryptoApiService= ApiService()


    var crypto= MutableLiveData<List<CryptoModel>>()

    fun getDataFromApı(string: String){
        System.out.println("bilgi"+string)
        try {
            disposable.add(
                cryptoApiService.getCryptoDetailData(string)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse))
        }catch (err: Exception){

        }
    }


    private fun handleResponse(cryptoList:List<CryptoModel>){
        cryptoModels= ArrayList(cryptoList)
        cryptoModels?.let {
            cryptoList.also { crypto.value = it }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}