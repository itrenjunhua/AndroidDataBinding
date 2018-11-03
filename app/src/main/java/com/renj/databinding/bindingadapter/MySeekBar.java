package com.renj.databinding.bindingadapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-11-03   19:59
 * <p>
 * 描述：使用 {@link BindingAdapter} 和 {@link InverseBindingAdapter} 注解对 {@link MySeekBar} 的 myProgress 属性进行双向绑定
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class MySeekBar extends android.support.v7.widget.AppCompatSeekBar {
    private static InverseBindingListener inverseBindingListener;

    public MySeekBar(Context context) {
        super(context, null);
        init();
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 触发反向数据的传递
                if (inverseBindingListener != null)
                    inverseBindingListener.onChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @BindingAdapter(value = "myProgress", requireAll = false)
    public static void setMyProgress(MySeekBar mySeekBar, int progress) {
        // 防止死循环
        if (getMyProgress(mySeekBar) != progress) {
            mySeekBar.setProgress(progress);
        }
    }

    @InverseBindingAdapter(attribute = "myProgress", event = "myProgressAttrChanged")
    public static int getMyProgress(MySeekBar mySeekBar) {
        return mySeekBar.getProgress();
    }

    @BindingAdapter(value = {"myProgressAttrChanged"}, requireAll = false)
    public static void setMyProgressAttrChanged(MySeekBar mySeekBar, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            MySeekBar.inverseBindingListener = inverseBindingListener;
        } else {
            Log.e("MySeekBar", "InverseBindingListener Null Exception");
        }
    }
}
