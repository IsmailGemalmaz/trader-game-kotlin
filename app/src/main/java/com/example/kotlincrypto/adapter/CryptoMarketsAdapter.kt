package com.example.kotlincrypto.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.view.layout.CryptoItemLayout

class CryptoMarketsAdapter(val cryptoList:ArrayList<CryptoModel>, context:Context):
    RecyclerView.Adapter<CryptoMarketsAdapter.CryptoViewHolder>(){

    var mContext:Context = context
    class CryptoViewHolder(var view: View) :RecyclerView.ViewHolder(view.rootView){
        var layout:CryptoItemLayout = itemView as CryptoItemLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(CryptoItemLayout(mContext))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        var cryptoModel: CryptoModel =cryptoList.get(position)
        holder.layout.fillContent(cryptoModel,position)
    }
    override fun getItemCount(): Int {
        return cryptoList.size
    }

    fun updateCryptoList(newCountryList: List<CryptoModel>){
        cryptoList.clear()
        cryptoList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}
