package com.example.kotlincrypto.view.layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.view.Dialog.*
import com.example.kotlincrypto.view.base.BaseTemplateActivity
import kotlinx.android.synthetic.main.layout_item_crypto.view.*

class CryptoItemLayout(context: Context) : FrameLayout(context),View.OnClickListener {

     var  mContext:Context
     private val RESOURCE: Int = R.layout.layout_item_crypto
    lateinit var model:CryptoModel

    init {
        LayoutInflater.from(context).inflate(RESOURCE,this,true)
       mContext=context
        llCryotItem.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==llCryotItem){
            CryptoBottomDialog.showDialog(mContext as BaseTemplateActivity,model)
            //Toast.makeText(context,"${model.id}",Toast.LENGTH_LONG).show()
        }
    }

    fun fillContent(cryptoModel: CryptoModel,position:Int){
        model=cryptoModel
        tvPrice.text=model.price
        tvNumber.text=model.rank
        tvMarketCap.text=model.market_cap
        tvName.text=model.name
        tvCurrency.text=model.currency
    }


}