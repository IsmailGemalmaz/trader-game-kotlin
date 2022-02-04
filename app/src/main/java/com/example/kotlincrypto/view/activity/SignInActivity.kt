package com.example.kotlincrypto.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincrypto.R
import com.example.kotlincrypto.util.CustomSharedPreferences
import com.example.kotlincrypto.util.ValidationUtil
import com.example.kotlincrypto.view.base.BaseActivity
import com.example.kotlincrypto.viewmodel.activity.SiginInViewModel
import com.example.kotlincrypto.viewmodel.fragment.MarketsViewModel
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity(),View.OnClickListener {

    private lateinit var viewModel: SiginInViewModel
   private var eror:Boolean=true
    private var errorStatment:String?=null
   private var id:Int?=null

    companion object {
        fun start(activity: Activity){
            var intent= Intent(activity,SignInActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun createViews() {
        super.createViews()
        super.assignObjects()
        viewModel= ViewModelProvider(this).get(SiginInViewModel::class.java)
        observeLiveData()
    }

    override fun setListeners() {
        super.setListeners()
        btnSignIn.setOnClickListener(this)
        tvLoginInfoSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnSignIn){
            if(isValid()){
                requestControl()
            }
        }else if(v==tvLoginInfoSignUp){
            SignUpActivity.start(this)
        }
    }

    private fun requestControl(){
        val etEmail= etSignInEmail.editText?.text.toString().trim()
        val etPassword= etSignInPassword.editText?.text.toString().trim()
        viewModel.requestFromApi(etEmail,etPassword)
        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.walletError.observe(this,{err->
            err.let {
                eror=it
                if(it){
                    Toast.makeText(this,R.string.account_info,Toast.LENGTH_SHORT).show()
                }else{
                    MainActivity.start(this)
                    finish()
                }
            }
        })
        viewModel.wallerErrorStatment.observe(this,{errStamnet->
            errStamnet.let {
                errorStatment=it
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_sign_in
    }

    private fun isValid():Boolean{
        var isValid:Boolean=true
        var email:TextInputLayout=etSignInEmail
        var password:TextInputLayout=etSignInPassword
        var emailInput: String = email.editText?.text.toString().trim()
        var passwordInput:String= password.editText?.text.toString().trim()

        if(TextUtils.isEmpty(emailInput)){
            email.error="Boş bırakılamaz"
            isValid=false
        }else if(!ValidationUtil.email(emailInput)){
            email.error="Geçerli bir e-posta adresi girin"
            isValid=false
        }else if(TextUtils.isEmpty(passwordInput)){
            password.error="Boş bırakılamaz"
            isValid=false
        }else if(errorStatment=="errPassword"){
            password.error="Şifre Hatalı"
        }else if(errorStatment=="errEmail"){
            email.error="Böyle bir kullanıcı bulunamadı"
        }
        return isValid
    }






}