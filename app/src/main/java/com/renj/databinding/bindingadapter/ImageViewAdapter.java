package com.renj.databinding.bindingadapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-11-03   18:49
 * <p>
 * 描述：使用 {@link BindingAdapter} 注解给 {@link ImageView} 增加 url 属性，并且使用 {@link Glide} 加载图片<br/>
 * 所以，我们在使用 {@link ImageView} 控件时就可以直接增加 app:url 属性了，增加之后就可以直接使用并会自动加载图片了<br/>
 * 查看 {@link com.renj.databinding.activity.custom.BindingAdapterActivity}
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ImageViewAdapter {
    @BindingAdapter(value = {"url"})
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }
}
