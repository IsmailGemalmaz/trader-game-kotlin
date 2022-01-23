package com.example.kotlincrypto.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.view.layout.WalletItemLayout

class WalletAdapter(val walletList:ArrayList<WalletGetModel>, context: Context):
    RecyclerView.Adapter<WalletAdapter.WalletViewHolder>() {
    var mContext:Context = context
    class WalletViewHolder(var view:View): RecyclerView.ViewHolder(view.rootView) {
        var layout: WalletItemLayout = itemView as WalletItemLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
      return  WalletViewHolder(WalletItemLayout(mContext))
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        var walletModel: WalletGetModel =walletList.get(position)
        holder.layout.fillContent(walletModel,position)
    }

    override fun getItemCount(): Int {
        return walletList.size
    }

    fun updateWalletList(walletUpdateList: List<WalletGetModel>){
        walletList.clear()
        walletList.addAll(walletUpdateList)
        notifyDataSetChanged()
    }
}