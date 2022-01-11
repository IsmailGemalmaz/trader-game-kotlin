package com.example.kotlincrypto.view.layout

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.CryptoModel
import com.example.kotlincrypto.view.Dialog.*
import com.example.kotlincrypto.view.activity.CryptoDetailActivity
import com.example.kotlincrypto.view.base.BaseTemplateActivity
import kotlinx.android.synthetic.main.layout_item_crypto.view.*

class CryptoItemLayout(context: Context) : FrameLayout(context),View.OnClickListener {


     var  mContext:Context
     private val RESOURCE: Int = R.layout.layout_item_crypto


    init {
        LayoutInflater.from(context).inflate(RESOURCE,this,true)
       mContext=context
        llCryotItem.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==llCryotItem){
            MenuFragmentBottomDialog.showDialog(mContext as BaseTemplateActivity)
            Toast.makeText(context,"basıldı",Toast.LENGTH_SHORT).show()
        }
    }

    fun fillContent(cryptoModel: CryptoModel){
        tvPrice.text=cryptoModel.price
        tvNumber.text=cryptoModel.rank
        tvMarketCap.text=cryptoModel.market_cap
        tvName.text=cryptoModel.name
        tvCurrency.text=cryptoModel.currency
    }
}