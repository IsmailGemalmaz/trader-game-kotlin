package com.example.kotlincrypto.viewmodel.fragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.service.ApiService
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class HomeViewModel(application: Application):BaseViewModel(application) {

    private val disposable= CompositeDisposable()
    private val cryptoApiService= ApiService()
    private var walletModels: ArrayList<WalletGetModel>? = null
    private val sharedPreferences=CustomSharedPreferences(getApplication())

    val wallet= MutableLiveData<List<WalletGetModel>>()
    val walletError= MutableLiveData<Boolean>()
    val walletLoading= MutableLiveData<Boolean>()



    fun refreshFromAPI(){
        getDataFromApı()
    }

    fun getDataFromApı(){

        try {
            walletLoading.value=true
            sharedPreferences.getUserId()?.let {
                cryptoApiService.getWalletData(it)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse)
            }?.let {
                disposable.add(
                    it
                )
            }
        }catch (err: Exception){
            walletError.value=true
            walletLoading.value=false
        }
    }

    private fun handleResponse(walletList:List<WalletGetModel>){
        walletModels= ArrayList(walletList)

        walletModels?.let {
            wallet.value = walletList
            walletLoading.value = false
            walletError.value = false

        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}