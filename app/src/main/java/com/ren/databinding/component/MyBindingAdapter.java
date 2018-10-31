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
    // 注释掉该方法，如果不注释掉，在双向绑定时就需要对 view 如果是EditText时做特殊处理，
    // 增加文字改变监听，防止出现死循环。主要针对的是 "android:text" 属性
//    @BindingAdapter("android:text")
//    public abstract void setText(TextView view,String value);

    @BindingAdapter("android:textColor")
    public abstract void setTextColor(TextView view, int color);
}
