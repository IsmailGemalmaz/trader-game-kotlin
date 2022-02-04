package com.example.kotlincrypto.view.layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.view.Dialog.WalletBottomDialog
import com.example.kotlincrypto.view.base.BaseTemplateActivity
import kotlinx.android.synthetic.main.layout_item_crypto.view.tvName
import kotlinx.android.synthetic.main.layout_item_wallet.view.*

class WalletItemLayout(context: Context):FrameLayout(context),View.OnClickListener{
    var  mContext:Context
    lateinit var model:WalletGetModel
    private val RESOURCE: Int = R.layout.layout_item_wallet


    init {
        LayoutInflater.from(context).inflate(RESOURCE,this,true)
        mContext=context
        llWalletItem.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==llWalletItem){
            WalletBottomDialog.showDialog(mContext as BaseTemplateActivity,model)
        }
    }

    fun fillContent(walletModel: WalletGetModel, position:Int){
        model=walletModel
        tvWalletCurrency.text=model.currency
        tvName.text=model.name
        tvAmount.setText("$ ${model.amount}")

    }

}