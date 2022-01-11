package com.example.kotlincrypto.view.base

import androidx.fragment.app.FragmentActivity

abstract class BaseUtilityDialog:BaseTemplateDialog() {

    open fun show(activity: FragmentActivity) {
        if (!activity.isFinishing) {
            show(activity.supportFragmentManager, null)
        }
    }

}