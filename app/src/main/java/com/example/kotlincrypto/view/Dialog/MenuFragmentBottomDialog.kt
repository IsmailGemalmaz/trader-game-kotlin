package com.example.kotlincrypto.view.Dialog

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.model.entity.CryptoModel
import com.example.kotlincrypto.view.activity.CryptoDetailActivity
import com.example.kotlincrypto.view.base.BaseDialog
import com.example.kotlincrypto.view.base.BaseTemplateActivity
import kotlinx.android.synthetic.main.dialog_bottom_fragment_menu.*

open class MenuFragmentBottomDialog : BaseDialog(),View.OnClickListener{
    lateinit var model:CryptoModel
companion object {
    fun showDialog(activity: FragmentActivity,model: CryptoModel){
        val alert= MenuFragmentBottomDialog()
        alert.setStock(model)
        alert.show(activity)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_bottom_fragment_menu
    }

    override fun createViews() {
        super.createViews()
        btnBuy.setText("Satın Al (${ model.currency})")
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
            activity?.let { CryptoDetailActivity.start(it,model.id.toString()) }
            dismiss()
        }else if(v==btnCancel){
            dismiss()
        }else if(v==llDialog){
            dismiss()
        }else if(v==btnBuy){
            activity?.let { GetInformationDialog.showDialog(it,model) }
            dismiss()
        }
    }
    open fun setStock(stock:CryptoModel) {
        model = stock
    }

}