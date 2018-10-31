package com.ren.databinding.component;

import android.widget.TextView;

import com.ren.databinding.R;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:30
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ReleaseBindingAdapter extends MyBindingAdapter {
//    @Override
//    public void setText(TextView view, String value) {
//        view.setText(value);
//    }

    @Override
    public void setTextColor(TextView view, int color) {
        view.setTextColor(view.getResources().getColor(R.color.color_default_text));
    }
}
