package com.debopam.imageloader

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ImageLoader {
    fun loadImage(activity: Activity, defaultIcon: Int, img_holder: ImageView, url: String?) {
        var defaultIcon = defaultIcon
        Glide.with(activity).clear(img_holder)
        if (defaultIcon == 0) defaultIcon = R.drawable.no_image
        Glide.with(activity).load(url).placeholder(defaultIcon).error(defaultIcon)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true).into(img_holder)
    }
}