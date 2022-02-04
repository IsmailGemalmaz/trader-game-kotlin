package com.example.kotlincrypto.view.base

import com.example.kotlincrypto.util.CustomSharedPreferences
import java.util.concurrent.atomic.AtomicInteger

abstract class BaseUtilityActivity :BaseTemplateActivity(){
    private val sEventIdGeneratorIndex = AtomicInteger(1)
    private val sRequestCodeGeneratorIndex = AtomicInteger(1)
    private val sExtraIdGeneratorIndex = AtomicInteger(1)

    open fun getNewExtraId(): String? {
        return "extra_" +sExtraIdGeneratorIndex.getAndIncrement()
    }

    open fun getPreference(): CustomSharedPreferences? {
        return CustomSharedPreferences()
    }

}