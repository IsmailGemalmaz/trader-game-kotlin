package com.example.kotlincrypto.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlincrypto.R
import com.example.kotlincrypto.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(),View.OnClickListener {

    companion object {
        fun start(activity: Activity){
            var intent= Intent(activity,SignUpActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun setListeners() {
        super.setListeners()
        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnSignUp){
            SignInActivity.start(this)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_sign_up
    }
}