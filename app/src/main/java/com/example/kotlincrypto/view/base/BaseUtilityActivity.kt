package com.example.kotlincrypto.view.base

import java.util.concurrent.atomic.AtomicInteger

abstract class BaseUtilityActivity :BaseTemplateActivity(){
    private val sEventIdGeneratorIndex = AtomicInteger(1)
    private val sRequestCodeGeneratorIndex = AtomicInteger(1)
    private val sExtraIdGeneratorIndex = AtomicInteger(1)

    open fun getNewExtraId(): String? {
        return "extra_" +sExtraIdGeneratorIndex.getAndIncrement()
    }

}