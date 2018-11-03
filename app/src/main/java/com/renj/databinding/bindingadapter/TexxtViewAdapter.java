package com.renj.databinding.bindingadapter;

import android.content.res.ColorStateList;
import android.databinding.InverseBindingAdapter;
import android.widget.TextView;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-11-03   18:53
 * <p>
 * 描述：使用 {@link InverseBindingAdapter} 注解给 {@link TextView} 的 textColor 属性增加逆向/反向绑定
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class TexxtViewAdapter {
    @InverseBindingAdapter(attribute = "android:textColor", event = "android:textColorAttrChanged")
    public static ColorStateList getTextColors(TextView view) {
        return view.getTextColors();
    }
}
