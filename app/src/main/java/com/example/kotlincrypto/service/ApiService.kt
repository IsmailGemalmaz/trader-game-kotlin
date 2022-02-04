package com.example.kotlincrypto.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlincrypto.constant.ApiEndpoint
import com.example.kotlincrypto.model.entity.*
import com.example.kotlincrypto.service.ServiceBuilder.apiGetBuild
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiService {

    fun addWallet(walletData: WalletPostModel, onResult:(WalletPostModel)->Unit){
        val retrofit = ServiceBuilder.buildService(Api::class.java,ApiEndpoint.APP_API_BASE)
        retrofit.addWallet(ApiEndpoint.APP_BUY_WALLET,walletData).enqueue(
            object : Callback<WalletPostModel> {
                override fun onFailure(call: Call<WalletPostModel>, t: Throwable) {
                    onResult
                }
                override fun onResponse(call: Call<WalletPostModel>, response: Response<WalletPostModel>) {
                    val buyWallet = response.body()
                    if (buyWallet != null) {
                            onResult(buyWallet)
                            Log.e("info",response.body().toString())

                    }
                }
            })
    }
    fun sellWallet(walletId: Int,walletData: WalletSellModel, onResult:(WalletSellModel)->Unit){
        val retrofit = ServiceBuilder.buildService(Api::class.java,ApiEndpoint.APP_API_BASE)
        retrofit.sellWallet(ApiEndpoint.APP_SELL_WALLET+walletId,walletData).enqueue(
            object : Callback<WalletSellModel> {
                override fun onFailure(call: Call<WalletSellModel>, t: Throwable) {
                    onResult
                }
                override fun onResponse(call: Call<WalletSellModel>, response: Response<WalletSellModel>) {
                    val sellWallet = response.body()
                    if (sellWallet != null) {
                        onResult(sellWallet)
                    }
                }
            })
    }

    fun loginUser( loginData: LoginModel, onResult:(LoginModel)->Unit){
        val retrofit = ServiceBuilder.buildService(Api::class.java,ApiEndpoint.APP_API_BASE)
        retrofit.loginUser(ApiEndpoint.APP_LOGİN_USER,loginData).enqueue(
            object : Callback<LoginModel> {
                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    onResult
                }
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    val login = response.body()
                    var err=response.body()?.error
                    if (login != null) {
                        onResult(login)
                       // resultErr==err
                        Log.e("error",err.toString())
                        Log.e("bilgi",login.toString())
                    }
                }
            })
    }


    fun getCryptoData(): Observable<List<CryptoModel>> {
        return apiGetBuild(ApiEndpoint.CRYPTO_NOMICS_BASE).getCrypto(ApiEndpoint.CRYPTO_INFO)
    }

    fun getCryptoDetailData(string:String):Observable<List<CryptoModel>>{
        return apiGetBuild(ApiEndpoint.CRYPTO_NOMICS_BASE).getCrypto(ApiEndpoint.CRYPTO_DETAİL+string)
    }

    fun getWalletData(userId: Int): Observable<List<WalletGetModel>> {
        return apiGetBuild(ApiEndpoint.APP_API_BASE).getWallet(ApiEndpoint.APP_GET_WALLET+userId)
    }


}