package com.example.kotlincrypto.service

import com.example.kotlincrypto.constant.ApiEndpoint
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.model.entity.WalletPostModel
import com.example.kotlincrypto.service.ServiceBuilder.apiGetBuild
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiService {

    fun addWallet(walletData: WalletPostModel, onResult:(WalletPostModel)->Unit){
        val retrofit = ServiceBuilder.buildService(Api::class.java,ApiEndpoint.APP_API_BASE)
        retrofit.addWallet(ApiEndpoint.APP_POST_WALLET,walletData).enqueue(
            object : Callback<WalletPostModel> {
                override fun onFailure(call: Call<WalletPostModel>, t: Throwable) {
                    onResult
                }
                override fun onResponse(call: Call<WalletPostModel>, response: Response<WalletPostModel>) {
                    val addedUser = response.body()
                    if (addedUser != null) {
                        onResult(addedUser)
                    }
                }
            }
        )
    }

    fun getCryptoData(): Observable<List<CryptoModel>> {
        return apiGetBuild(ApiEndpoint.CRYPTO_NOMICS_BASE).getCrypto(ApiEndpoint.CRYPTO_INFO)
    }

    fun getCryptoDetailData(string:String):Observable<List<CryptoModel>>{
        return apiGetBuild(ApiEndpoint.CRYPTO_NOMICS_BASE).getCrypto(ApiEndpoint.CRYPTO_DETAİL+string)
    }

    fun getWalletData(): Observable<List<WalletGetModel>> {

        return apiGetBuild(ApiEndpoint.APP_API_BASE).getWallet(ApiEndpoint.APP_GET_WALLET)
    }
}