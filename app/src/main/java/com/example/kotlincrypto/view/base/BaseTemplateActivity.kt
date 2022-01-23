package com.example.kotlincrypto.view.base


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import android.R.id.content

abstract class BaseTemplateActivity : AppCompatActivity() {


    var context: Context = this
    var activity = this


    private var mIsRecreated = false

    open fun getLayoutId(): Int {
        return -1
    }

   open fun createViews() {}

   open fun assignObjects() {}

     open fun setListeners() {}

    fun prepareUI() {}

    @CallSuper
    open fun onLayoutReady() {
    }

    @CallSuper
    open fun onCreated() {
    }

    @CallSuper
    open fun onStarted() {
    }

    @CallSuper
    open fun onResumed() {
    }

    @CallSuper
    open fun onPaused() {
    }

    @CallSuper
    open fun onStopped() {
    }

    @CallSuper
    open fun onDestroyed() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIsRecreated = savedInstanceState != null

        onCreated()
        initialize()
    }



    override fun onStart() {
        super.onStart()
        if (!mIsRecreated) {
            onStarted()
        }
    }

    override fun onResume() {
        super.onResume()
        if (!mIsRecreated) {
            onResumed()
        }
    }

    override fun onPause() {
        super.onPause()
        if (!mIsRecreated) {
            onPaused()
        }
    }

    override fun onStop() {
        super.onStop()
        if (!mIsRecreated) {
            onStopped()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!mIsRecreated) {
            onDestroyed()
        }
    }

     fun isRecreated(): Boolean {
        return mIsRecreated
    }



    private fun initialize() {
        val layoutId = getLayoutId()
        if (layoutId != -1) {
            setContentView(layoutId)
        }
        createViews()
        assignObjects()
        setListeners()
        prepareUI()
        //setOnGlobalLayoutListenerToContentView()
    }

    private fun restartApp() {
        val intent = baseContext.packageManager.getLaunchIntentForPackage(baseContext.packageName)
        intent!!.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }



}