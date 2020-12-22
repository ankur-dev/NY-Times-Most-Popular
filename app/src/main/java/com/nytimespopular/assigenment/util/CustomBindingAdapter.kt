package com.nytimespopular.assigenment.util

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.nytimespopular.assigenment.R

class CustomBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            try {
                if (!TextUtils.isEmpty(imageUrl)) {
                    Glide.with(imageView.context).load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .addListener(object : RequestListener<Drawable> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                        })
                        .into(imageView)
                }else{
                    imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.colorPrimary))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}