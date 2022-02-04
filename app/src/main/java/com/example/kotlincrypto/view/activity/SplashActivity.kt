package com.example.kotlincrypto.view.activity

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.kotlincrypto.R
import android.net.ConnectivityManager
import android.view.View
import android.widget.Toast
import com.example.kotlincrypto.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity :BaseActivity(){

    private val SPLASH_TIME:Long=2000
    lateinit var manager:ConnectivityManager

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }


    override fun createViews() {
        super.createViews()
        manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        Handler(Looper.myLooper()!!).postDelayed({
            if(manager.activeNetwork !=null){
                startActivity(Intent(this,SignInActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,R.string.no_connection_internet,Toast.LENGTH_SHORT).show()
                finish()
            }

        },SPLASH_TIME)
    }


}