package com.example.kotlincrypto.viewmodel.fragment

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.service.ApiService
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class  MarketsViewModel(application: Application):BaseViewModel(application) {

    private val disposable= CompositeDisposable()
    private val cryptoApiService=ApiService()
    //private var cryptoModels: ArrayList<CryptoModel>? = null
    private var customPreferences=CustomSharedPreferences(getApplication())
    private val SPLASH_TIME:Long=50000

    val crypto=MutableLiveData<List<CryptoModel>>()
    val cryptoError=MutableLiveData<Boolean>()
    val cryptoLoading=MutableLiveData<Boolean>()

    fun refreshData(){
        Handler(Looper.myLooper()!!).postDelayed({
            getDataFromApı()
        },SPLASH_TIME)
    }

    fun refreshFromAPI(){
        getDataFromApı()
    }

     fun getDataFromApı(){
         try {
             cryptoLoading.value=true
             disposable.add(
                      cryptoApiService.getCryptoData()
                     .subscribeOn(Schedulers.newThread())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(this::handleResponse))
         }catch (err:Exception){
             cryptoError.value=true
             cryptoLoading.value=false
         }
    }

    private fun handleResponse(cryptoList:List<CryptoModel>){

        crypto?.let {
            crypto.value = cryptoList
            cryptoLoading.value = false
            cryptoError.value = false
        }
        /*
            cryptoModels= ArrayList(cryptoList)
         cryptoModels?.let {
            crypto.value = cryptoList
            cryptoLoading.value = false
            cryptoError.value = false

        }*/
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}