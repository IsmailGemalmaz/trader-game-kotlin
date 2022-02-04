package com.example.kotlincrypto.view.base

import androidx.fragment.app.FragmentActivity
import com.example.kotlincrypto.util.CustomSharedPreferences

abstract class BaseUtilityDialog:BaseTemplateDialog() {


    open fun show(activity: FragmentActivity) {
        if (!activity.isFinishing) {
            show(activity.supportFragmentManager, null)
        }
    }

    override fun dismiss() {
        dismissAllowingStateLoss()
    }

    open fun onEventReceive(event: Int, vararg data: Any?) {}

    open fun getPreference(): CustomSharedPreferences? {
        return CustomSharedPreferences()
    }


}