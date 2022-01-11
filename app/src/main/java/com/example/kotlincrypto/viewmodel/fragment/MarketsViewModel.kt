package com.example.kotlincrypto.viewmodel.fragment

import android.app.Application
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.constant.ApiEndpoint
import com.example.kotlincrypto.model.CryptoModel
import com.example.kotlincrypto.service.CryptoApiService
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.view.activity.MainActivity
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MarketsViewModel(application: Application):BaseViewModel(application) {

    private val disposable= CompositeDisposable()
    private val cryptoApiService=CryptoApiService()
    private var cryptoModels: ArrayList<CryptoModel>? = null
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
                 cryptoApiService.getData()
                     .subscribeOn(Schedulers.newThread())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(this::handleResponse))
         }catch (err:Exception){
             cryptoError.value=true
             cryptoLoading.value=false
         }

    }

    private fun handleResponse(cryptoList:List<CryptoModel>){
            cryptoModels= ArrayList(cryptoList)

        cryptoModels?.let {
            crypto.value = cryptoList
            cryptoLoading.value = false
            cryptoError.value = false

        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}