package com.example.kotlincrypto.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrypto.model.CryptoModel
import com.example.kotlincrypto.view.layout.CryptoItemLayout

class CryptoMarketsAdapter(val cryptoList:ArrayList<CryptoModel>, context: Context):
    RecyclerView.Adapter<CryptoMarketsAdapter.CryptoViewHolder>(){

    var mContext:Context = context

    class CryptoViewHolder(var view: View) :RecyclerView.ViewHolder(view.rootView){
         var layout:CryptoItemLayout = itemView as CryptoItemLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        /*
        var inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.layout_item_crypto,parent,false)*/
        return CryptoViewHolder(CryptoItemLayout(mContext))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        var cryptoModel:CryptoModel=cryptoList.get(position)
        holder.layout.fillContent(cryptoModel)
        /*
        holder.view.tvPrice.text=cryptoList[position].price
        holder.view.tvCurrency.text=cryptoList[position].currency
        holder.view.tvMarketCap.text=cryptoList[position].market_cap
        holder.view.tvName.text=cryptoList[position].name
        holder.view.tvNumber.text=cryptoList[position].rank*/

    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    fun updateCountryList(newCountryList: List<CryptoModel>){
       cryptoList.clear()
        cryptoList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}