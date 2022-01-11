package com.example.kotlincrypto.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object {
        private val PREFERENCES_TIME="time"
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

    fun saveTime(time:Long){
        sharedPrefences?.edit(commit=true){
            putLong(PREFERENCES_TIME,time)
        }
    }

    fun getTime()= sharedPrefences?.getLong(PREFERENCES_TIME,0)
}