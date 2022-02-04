package com.example.kotlincrypto.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object {
        private val PREFERENCES_TOKEN="token"
        private val PREFERENCES_USERID="userId"
        private var sharedPrefences: SharedPreferences?=null

        @Volatile private var instance :CustomSharedPreferences?=null
        private val lock=Any()

        operator fun invoke(context: Context):CustomSharedPreferences= instance?: synchronized(lock){
            instance?: makeCustomSharedPReferences(context).also {
                instance= it
            }
        }

        private fun makeCustomSharedPReferences(context: Context):CustomSharedPreferences{
            sharedPrefences= PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }

    fun saveToken(jwtToken:String){
        sharedPrefences?.edit(commit=true){
            putString(PREFERENCES_TOKEN,jwtToken)
        }
    }

    fun getToken()= sharedPrefences?.getString(PREFERENCES_TOKEN,"TOKEN VALUE")

    fun saveUserId(userId:Int){
        sharedPrefences?.edit(commit=true){
            putInt(PREFERENCES_USERID,userId)
        }
    }

    fun getUserId()= sharedPrefences?.getInt(PREFERENCES_USERID,0)
}