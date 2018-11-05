package com.renj.databinding.weight;

import android.content.Context;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
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
 * 描述：使用 {@link InverseBindingMethods} 和 {@link InverseBindingMethod} 注解对 {@link MySeekBar2} 的 progress 属性进行反向绑定
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
@InverseBindingMethods({
        @InverseBindingMethod(type = MySeekBar2.class,attribute = "myProgress2",event = "myProgress2AttrChange",method = "getMyProgress2")
})
public class MySeekBar2 extends android.support.v7.widget.AppCompatSeekBar {
    private static InverseBindingListener inverseBindingListener;

    public MySeekBar2(Context context) {
        super(context, null);
        init();
    }

    public MySeekBar2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySeekBar2(Context context, AttributeSet attrs, int defStyleAttr) {
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

    public void setMyProgress2(int progress) {
        // 防止死循环
        if (getMyProgress2() != progress) {
            setProgress(progress);
        }
    }

    public int getMyProgress2() {
        return getProgress();
    }

    public void myProgress2AttrChange(InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            MySeekBar2.inverseBindingListener = inverseBindingListener;
        } else {
            Log.e("MySeekBar2", "InverseBindingListener Null Exception");
        }
    }
}
