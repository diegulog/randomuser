package com.diegulog.randomuser.utils

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(path: String) {
    Glide.with(this.context).load(path).into(this)
}

fun ImageView.load(bitmap: Bitmap) {
    Glide.with(this.context).load(bitmap).into(this)
}
