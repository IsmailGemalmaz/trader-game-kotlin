package com.example.kotlincrypto.view.activity


import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlincrypto.R
import com.example.kotlincrypto.view.base.BaseActivity
import com.example.kotlincrypto.view.base.BaseTemplateActivity
import com.example.kotlincrypto.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity:BaseActivity() {

    private val homeFragment=HomeFragment()
    private val marketsFragment=MarketsFragment()
    private val settingsFragment=SettingsFragment()
    private val sortingFragment=SortingFragment()
    private val walletFragment=WalletFragment()


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createViews() {
        super.createViews()
        replaceFragment(homeFragment)
        bv_navigation.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_markets -> replaceFragment(marketsFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
                R.id.ic_sorting -> replaceFragment(sortingFragment)
                R.id.ic_wallet -> replaceFragment(walletFragment)
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