package com.renj.databinding.weight;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.util.AttributeSet;

import com.renj.databinding.utils.UIUtil;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-11-05   10:26
 * <p>
 * 描述：使用 {@link BindingMethods} 和 {@link BindingMethod} 注解组合给自定义控件 {@link MyTextView} 增加 textChangeToast 属性，
 * 并绑定 {@link MyTextView#onTextChangeToast(String)} 方法，<br/>
 * 查看 {@link com.renj.databinding.activity.custom.BindingMethodsActivity}
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
@BindingMethods({
        @BindingMethod(type = MyTextView.class, attribute = "textChangeToast", method = "onTextChangeToast")
})
public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onTextChangeToast(String content) {
        UIUtil.showToast(content);
    }
}
