package com.ren.databinding.component;

import android.databinding.BindingAdapter;
import android.widget.TextView;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:29
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public abstract class MyBindingAdapter {
    @BindingAdapter("android:text")
    public abstract void setText(TextView view,String value);

    @BindingAdapter("android:textColor")
    public abstract void setTextColor(TextView view, int color);
}
