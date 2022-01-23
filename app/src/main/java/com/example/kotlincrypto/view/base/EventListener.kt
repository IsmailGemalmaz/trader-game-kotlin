package com.example.kotlincrypto.view.base

interface EventListener  {
    fun onEventReceive(event: Int, vararg data: Any?)
}