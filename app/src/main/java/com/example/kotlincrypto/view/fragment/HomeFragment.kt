package com.example.kotlincrypto.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincrypto.R
import com.example.kotlincrypto.adapter.CryptoMarketsAdapter
import com.example.kotlincrypto.adapter.WalletAdapter
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.view.base.BaseFragment
import com.example.kotlincrypto.viewmodel.fragment.HomeViewModel
import com.example.kotlincrypto.viewmodel.fragment.MarketsViewModel

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_markets.*


class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel
    var walletAdapter:WalletAdapter?=null
    var list:List<WalletGetModel>?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.refreshFromAPI()
        observeLiveData()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    private fun observeLiveData(){
        viewModel.wallet.observe(viewLifecycleOwner,{wallet ->
            wallet?.let {
                list=ArrayList(it)
                Log.e("Data wallet",list.toString())

                walletAdapter= context?.let { it1 ->
                    WalletAdapter(arrayListOf(),
                        it1
                    )
                }

                rvWalletList.layoutManager= LinearLayoutManager(context)
                rvWalletList.adapter=walletAdapter
                walletAdapter?.updateWalletList(wallet)

            }
        })
    }
}
