package com.example.kotlincrypto.view.Dialog

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.view.base.BaseDialog

class GetInformationDialog:BaseDialog() {



    fun showDialog(activity:FragmentActivity){
        var getInformationDialog=GetInformationDialog()
        getInformationDialog.showDialog(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.AppTheme_NoActionBar_Translucent)
    }

    override fun getLayoutId(): Int {
       return R.layout.dialog_get_information
    }
}