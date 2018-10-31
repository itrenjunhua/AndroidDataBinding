package com.ren.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ren.databinding.BR;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   14:24
 * <p>
 * 描述：双向绑定使用的Bean
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class TwoWayBean extends BaseObservable {
    private String fastName;
    private String lastName;

    @Bindable
    public String getFastName() {
        return fastName;
    }

    public void setFastName(String fastName) {
        this.fastName = fastName;
        notifyPropertyChanged(BR.fastName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
