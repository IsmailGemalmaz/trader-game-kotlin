package com.example.kotlincrypto.view.Dialog

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.model.entity.WalletGetModel
import com.example.kotlincrypto.view.activity.CryptoDetailActivity
import com.example.kotlincrypto.view.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_bottom_crypto.*
import kotlinx.android.synthetic.main.dialog_bottom_crypto.btnBuy
import kotlinx.android.synthetic.main.dialog_bottom_crypto.btnCancel
import kotlinx.android.synthetic.main.dialog_bottom_crypto.btnDetail
import kotlinx.android.synthetic.main.dialog_bottom_crypto.llDialog
import kotlinx.android.synthetic.main.dialog_bottom_wallet.*

class WalletBottomDialog: BaseDialog(),View.OnClickListener {

    lateinit var model: WalletGetModel

    companion object {
        fun showDialog(activity: FragmentActivity, model: WalletGetModel){
            val alert= WalletBottomDialog()
            alert.setStock(model)
            alert.show(activity)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_bottom_wallet
    }

    override fun createViews() {
        super.createViews()
        btnBuy.setText("Sat (${ model.currency})")
        btnDetail.setText("Detaylı İncele (${ model.currency})")
    }

    override fun setListeners() {
        super.setListeners()
        btnDetail.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
        llDialog.setOnClickListener(this)
        btnBuy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnDetail){
            activity?.let { CryptoDetailActivity.start(it,model.currency.toString()) }
            dismiss()
        }else if(v==btnCancel){
            dismiss()
        }else if(v==llDialog){
            dismiss()
        }else if(v==btnBuy){
           activity?.let { GetSellInformationDialog.showDialog(it,model) }
            dismiss()
        }
    }
    open fun setStock(stock: WalletGetModel) {
        model = stock
    }
}