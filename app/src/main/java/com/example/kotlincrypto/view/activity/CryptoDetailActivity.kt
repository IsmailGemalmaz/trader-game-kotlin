package com.example.kotlincrypto.view.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.kotlincrypto.R
import com.example.kotlincrypto.view.base.BaseActivity
import com.example.kotlincrypto.view.base.BaseTemplateActivity

class CryptoDetailActivity :BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_crypto_detail
    }

    companion object {
        fun start(activity: Activity){
            var intent=Intent(activity,CryptoDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }

}