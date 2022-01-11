package com.example.kotlincrypto.view.base

import android.content.Intent
import androidx.annotation.StringRes

abstract class BaseManager {
    var activity: BaseManagerActivity? = null

    open fun onCreated() {}

    open fun onStarted() {}

    open fun onResumed() {}

    open fun onLayoutReady() {}

    open fun onPaused() {}

    open fun onStopped() {}

    open fun onDestroyed() {}

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    open fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>?,
        grantResults: IntArray?
    ) {
    }

    open fun BaseManager(activity: BaseManagerActivity?) {
        this.activity = activity
        this.activity?.registerManager(this)
    }

    fun destroy() {
        activity = null
    }

    fun getString(@StringRes resId: Int): String {
        return activity!!.getString(resId)
    }
}