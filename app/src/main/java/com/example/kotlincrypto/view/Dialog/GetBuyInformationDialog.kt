package com.example.kotlincrypto.view.Dialog

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.model.entity.WalletPostModel
import com.example.kotlincrypto.service.ApiService
import com.example.kotlincrypto.view.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_information_buy.*

class GetBuyInformationDialog:BaseDialog(),View.OnClickListener {

    lateinit var model:CryptoModel
    companion object{

        fun showDialog(activity:FragmentActivity,model:CryptoModel){
            var getInformationDialog=GetBuyInformationDialog()
            getInformationDialog.setStock(model)
            getInformationDialog.show(activity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.AppTheme_NoActionBar_Translucent)
    }

    override fun createViews() {
        super.createViews()
        tvInfoCurrency.setText(model.currency)
    }
    override fun getLayoutId(): Int {
       return R.layout.dialog_information_buy
    }

    override fun setListeners() {
        super.setListeners()
        btnInformationBuy.setOnClickListener(this)
        ibClose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnInformationBuy){
            addDummyWallet()
            Toast.makeText(context,"Cüzdana Eklendi ${model.currency}",Toast.LENGTH_LONG).show()
            dismiss()
        }else if(v==ibClose){
            dismiss()
        }
    }

    fun addDummyWallet() {
        val etAmount= etAmountt.editText?.text.toString().trim()
        val apiService =ApiService()
        val userInfo = WalletPostModel(  userId = 2,
            currency = model.currency,
            amount = etAmount
        )
        apiService.addWallet(userInfo){
            if(it.userId!=null&&it.currency!=null&&it.amount!=null){
                print("eklendi")
            }else{
             print("hata")
            }
        }

    }

    open fun setStock(stock:CryptoModel) {
        model = stock
    }
}