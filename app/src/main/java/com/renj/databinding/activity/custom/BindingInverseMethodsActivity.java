package com.renj.databinding.activity.custom;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingInverseMethodsBinding;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   10:03
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class BindingInverseMethodsActivity extends AppCompatActivity {
    private ActivityBindingInverseMethodsBinding binding;

    public final ObservableInt myProgress = new ObservableInt();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_binding_inverse_methods);

        myProgress.set(0);
        binding.setMyProgress(myProgress);
    }
}
