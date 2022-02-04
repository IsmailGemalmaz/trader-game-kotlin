package com.example.kotlincrypto.util

import android.text.TextUtils
import java.util.regex.Pattern

 class ValidationUtil {

     companion object{
         fun email(email: String): Boolean {
             var boolean:Boolean=true
             val regExpn =
                 "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@" + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|" + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,10})$"
             val inputStr: CharSequence = email
             val pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE)
             val matcher = pattern.matcher(inputStr)
             if(!matcher.matches()){
                 boolean=false
             }
             return boolean
         }

         fun nameSurname(name: String): Boolean {
             var name = name
             var rtn = false
             name = name.trim { it <= ' ' }.replace("  ", " ")
             if (name.split(" ").toTypedArray().size > 1) {
                 val names = name.split(" ").toTypedArray()
                 if (names[0].length > 1 && names[1].length > 1) rtn = true
             }
             return rtn
         }

         fun username(username: String?): Boolean {
             val pattern = "^[a-z0-9_.]{3,30}$"
             return Pattern.compile(pattern).matcher(username).matches()
         }

         fun password(password: String): Boolean {
             return if (TextUtils.isEmpty(password) || password.length < 6) {
                 false
             } else true
         }
     }

}