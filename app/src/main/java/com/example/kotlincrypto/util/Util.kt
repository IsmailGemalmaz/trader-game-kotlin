package com.example.kotlincrypto.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlincrypto.R

fun ImageView.downloadFromUrl(url:String?, progressDrawable: CircularProgressDrawable){

    val options= RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)//default olarak ne resmi gösterecek

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun placeHolderProgresBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}