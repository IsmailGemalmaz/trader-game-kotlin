package com.example.kotlincrypto.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincrypto.R
import com.example.kotlincrypto.adapter.CryptoMarketsAdapter
import com.example.kotlincrypto.view.base.BaseFragment
import com.example.kotlincrypto.view.base.BaseTemplateFragment
import com.example.kotlincrypto.viewmodel.fragment.MarketsViewModel
import kotlinx.android.synthetic.main.fragment_markets.*


class MarketsFragment :BaseFragment() {

    private lateinit var viewModel:MarketsViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_markets
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view model intialize
        viewModel= ViewModelProvider(this).get(MarketsViewModel::class.java)
        viewModel.refreshFromAPI()

        observeLiveData()
        srMarkets.setOnRefreshListener {
            viewModel.refreshFromAPI()
            srMarkets.isRefreshing=false
            prCryptoLoading.visibility=View.GONE
        }
    }

    private fun observeLiveData() {
        viewModel.crypto.observe(viewLifecycleOwner,{crypto->
            crypto?.let{
                Log.e("Data",crypto.toString())
                //rcyclerview intialize
                val cryptoMarketsAdapter= context?.let { CryptoMarketsAdapter(arrayListOf(), it) }
                rvCryptoList.layoutManager= LinearLayoutManager(context)

                rvCryptoList.adapter=cryptoMarketsAdapter
                cryptoMarketsAdapter?.updateCountryList(crypto)
                prCryptoLoading.visibility=View.GONE
                tvCryptoError.visibility=View.GONE
                rvCryptoList.visibility=View.VISIBLE
            }
        })

        viewModel.cryptoError.observe(viewLifecycleOwner,{ error->
            error?.let {
                if(it){
                    tvCryptoError.visibility=View.VISIBLE
                }else{
                    tvCryptoError.visibility=View.GONE
                }
            }
        })

        viewModel.cryptoLoading.observe(viewLifecycleOwner,{loading->
            loading?.let {
                if(it){
                    prCryptoLoading.visibility=View.VISIBLE
                    tvCryptoError.visibility=View.GONE

                }else{
                    prCryptoLoading.visibility=View.GONE
                }

            }
        })
    }


}