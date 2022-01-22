package com.example.kotlincrypto.view.activity

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincrypto.R
import com.example.kotlincrypto.constant.CryptoStockItemType
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.view.base.BaseActivity
import com.example.kotlincrypto.viewmodel.activity.CryptoDetailViewModel
import kotlinx.android.synthetic.main.activity_crypto_detail.*


class CryptoDetailActivity :BaseActivity(),View.OnClickListener {

    internal val EXTRA_STOCK_ID: kotlin.String? = getNewExtraId()

    private lateinit var viewModel: CryptoDetailViewModel
   // lateinit var list:List<CryptoModel>
    companion object {

        fun start(activity: Activity,string: kotlin.String){
            var intent=Intent(activity,CryptoDetailActivity::class.java)
            intent.putExtra("EXTRA_ID",string)
            activity.startActivity(intent)
        }
    }

    override fun createViews() {
        super.createViews()
        var id=intent.getStringExtra("EXTRA_ID")
        tvCoinName.setText(id)
        viewModel= ViewModelProvider(this).get(CryptoDetailViewModel::class.java)
        if (id != null) {
            viewModel.getDataFromApı(id)
        }
        observeLiveData()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_crypto_detail
    }

    override fun setListeners() {
        super.setListeners()
            ibDetailBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==ibDetailBack){
            onBackPressed()
        }
    }

    private fun observeLiveData() {
        viewModel.crypto.observe(this,{crypto->
            crypto?.let{
                Log.e("Data",crypto.toString())
                handleResponseData(crypto)
            } })
    }

    private fun handleResponseData(data:List<CryptoModel>){
        cDlCurrrency.fillContent(CryptoStockItemType.CURRENCY,("${data.get(0).name}(${data.get(0).currency})"))
        cDlRank.fillContent(CryptoStockItemType.RANK,("${data.get(0).rank}"))
        cDlPrice.fillContent(CryptoStockItemType.PRICE,("${data.get(0).price}"))
        cDlMarketCap.fillContent(CryptoStockItemType.MARKET_CAP,("${data.get(0).market_cap}"))
        cDlHigh.fillContent(CryptoStockItemType.HİGH,("${data.get(0).high}"))
        cDlHighTimesTamp.fillContent(CryptoStockItemType.HİGH_TİMES_TAMP,("${data.get(0).high_timestamp}"))
        cDlMarketCapDominance.fillContent(CryptoStockItemType.MARKET_CAP_DOMINANCE,("${data.get(0).market_cap_dominance}"))
        cDlMaxSuppley.fillContent(CryptoStockItemType.MAX_SUPPLY,("${data.get(0).max_supply}"))
        cDlCirculatingSupply.fillContent(CryptoStockItemType.CIRCULATING_SUPPLY,("${data.get(0).circulating_supply}"))
    }

}