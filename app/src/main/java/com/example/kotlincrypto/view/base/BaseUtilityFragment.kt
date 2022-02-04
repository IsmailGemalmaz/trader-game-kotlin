package com.example.kotlincrypto.view.base

import com.example.kotlincrypto.util.CustomSharedPreferences

abstract class BaseUtilityFragment :BaseTemplateFragment() {

    open fun getPreference(): CustomSharedPreferences? {
        return CustomSharedPreferences()
    }
}