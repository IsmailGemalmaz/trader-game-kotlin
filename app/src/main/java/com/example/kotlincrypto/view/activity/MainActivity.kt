package com.example.kotlincrypto.view.activity

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.kotlincrypto.R
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.view.base.BaseActivity
import com.example.kotlincrypto.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity:BaseActivity() {

    private val homeFragment=HomeFragment()
    private val marketsFragment=MarketsFragment()
    private val settingsFragment=SettingsFragment()
    private val sortingFragment=SortingFragment()
    private val walletFragment=WalletFragment()

    companion object {
        fun start(activity: Activity){
            var intent= Intent(activity,MainActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createViews() {
        super.createViews()
        replaceFragment(homeFragment)
        bv_navigation.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.ic_markets -> replaceFragment(marketsFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
              //  R.id.ic_sorting -> replaceFragment(sortingFragment)
                R.id.ic_home -> replaceFragment(homeFragment)
            }
            true
        }
    }


   private fun replaceFragment(fragment: Fragment){
       if(fragment!=null){
           val transaction=supportFragmentManager.beginTransaction()
           transaction.replace(R.id.fragmentContainer,fragment)
           transaction.commit()
       }
   }

}