package com.example.kotlincrypto.view.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

abstract class BaseTemplateDialog:DialogFragment(){
   internal var context: Context? = null
    var activity: BaseTemplateActivity? = null

    private var vgContent: ViewGroup? = null
    private var mIsActivityRecreated = false

    open fun getLayoutId(): Int{
         return -1
     }

    open fun createViews() {}

    open fun assignObjects() {}

    open fun setListeners() {}

    open fun prepareUI() {}

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
    }

  override  fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity = getActivity() as BaseTemplateActivity?
        context = activity
        val layoutId = getLayoutId()
        vgContent = inflater.inflate(layoutId, null) as ViewGroup

       // mIsActivityRecreated = activity!!.isRecreated()
        if (mIsActivityRecreated) {
            initialize()
            onCreated()
        }
        return vgContent
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onStart() {
        super.onStart()
        if (!mIsActivityRecreated) {
            onStarted()
        }
    }

    override fun onResume() {
        super.onResume()
        if (!mIsActivityRecreated) {
            onResumed()
        }
    }

    override fun onPause() {
        super.onPause()
        if (!mIsActivityRecreated) {
            onPaused()
        }
    }

    override fun onStop() {
        super.onStop()
        if (!mIsActivityRecreated) {
            onStopped()
        }
    }

   override fun onDestroyView() {
        super.onDestroyView()
        if (!mIsActivityRecreated) {
            onDestroyed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initialize() {
        createViews()
        assignObjects()
        setListeners()
        prepareUI()
        setOnGlobalLayoutListenerToContentView()
    }

    private  fun setOnGlobalLayoutListenerToContentView() {
        vgContent!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                vgContent!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
                vgContent!!.post { onLayoutReady() }
            }
        })
    }
}