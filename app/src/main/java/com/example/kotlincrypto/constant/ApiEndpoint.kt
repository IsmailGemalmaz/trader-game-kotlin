package com.example.kotlincrypto.constant

 object ApiEndpoint {

         const val MACHINE_IP_ADDRESS="192.168.0.105"

         const val CRYPTO_NOMICS_BASE:String="https://api.nomics.com/v1/"
         const val CRYPTO_INFO:String="currencies/ticker?key=a8a3452e71305947867f9f04df8fd319&per-page=100&page=1"
         const val CRYPTO_DETAİL:String="currencies/ticker?key=a8a3452e71305947867f9f04df8fd319&ids="

         const val APP_API_BASE="http://${MACHINE_IP_ADDRESS}:3000/api/v1/"
         const val APP_POST_WALLET="crypto/postwallet"
         const val APP_GET_WALLET="crypto/get"

}