package com.example.kotlincrypto.view.layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.kotlincrypto.R
import com.example.kotlincrypto.constant.CryptoStockItemType
import kotlinx.android.synthetic.main.layout_crypto_list_item_details.view.*
import kotlinx.android.synthetic.main.layout_item_crypto.view.*

class CryptoDetailListItemLayout(context: Context, attrs: AttributeSet?):
    FrameLayout(context, attrs) {
    private val RESOURCE: Int = R.layout.layout_crypto_list_item_details
    var  mContext:Context
    init {
        LayoutInflater.from(context).inflate(RESOURCE,this,true)
        mContext=context

    }

    fun fillContent(itemType: CryptoStockItemType, value: String) {
        if (CryptoStockItemType.CURRENCY === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("İsim")
        } else if (CryptoStockItemType.RANK === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Sıra")
        } else if (CryptoStockItemType.PRICE === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Fiyat")
        } else if (CryptoStockItemType.MARKET_CAP === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Piyasa Değeri")
        } else if (CryptoStockItemType.HİGH === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("En Yüksek Fiyat")
        } else if (CryptoStockItemType.HİGH_TİMES_TAMP === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("En Yüksek Zamanı")
            tvItemName.setTextSize(17f)
            getTvItemValue.setTextSize(17f)
        } else if (CryptoStockItemType.MARKET_CAP_DOMINANCE === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Dominance")
        } else if (CryptoStockItemType.MAX_SUPPLY === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Max. Arz")
        } else if (CryptoStockItemType.CIRCULATING_SUPPLY === itemType) {
            getTvItemValue.setText(value)
            tvItemName.setText("Dolaşan Arz")
        }
    }
}