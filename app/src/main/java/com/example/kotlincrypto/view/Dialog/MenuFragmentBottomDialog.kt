package com.example.kotlincrypto.view.Dialog

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.view.base.BaseDialog
import com.example.kotlincrypto.view.base.BaseTemplateActivity

open class MenuFragmentBottomDialog : BaseDialog(),View.OnClickListener {

companion object {
    fun showDialog(activity: FragmentActivity){
        val alert= MenuFragmentBottomDialog()
        alert.show(activity)
    }
}




    override fun getLayoutId(): Int {
       return R.layout.dialog_bottom_fragment_menu
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}