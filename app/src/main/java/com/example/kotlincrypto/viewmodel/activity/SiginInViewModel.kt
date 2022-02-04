package com.example.kotlincrypto.viewmodel.activity

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.model.entity.LoginModel
import com.example.kotlincrypto.service.ApiService
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.viewmodel.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.Exception

class SiginInViewModel(application: Application) : BaseViewModel(application) {

    private val disposable= CompositeDisposable()
    private val cryptoApiService= ApiService()
    private val sharedPreferences=CustomSharedPreferences(getApplication())

    val walletError=MutableLiveData<Boolean>()
    val wallerErrorStatment=MutableLiveData<String>()
    val userId=MutableLiveData<Int>()
    val jwtToken=MutableLiveData<String>()

    fun requestFromApi(email: String,password:String){
        try {
            val loginModel=LoginModel(email,password)
                cryptoApiService.loginUser(loginModel){
                    walletError.value=it.error
                    wallerErrorStatment.value=it.errStatment
                    it.jwtToken?.let { it1 -> sharedPreferences.saveToken(it1)}
                    it.userId?.let { it1 -> sharedPreferences.saveUserId(it1)}

                }

        }catch (err:Exception){

        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}