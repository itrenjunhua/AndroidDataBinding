package com.renj.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.renj.databinding.CustomClassNameBinding;

import com.renj.databinding.R;
import com.renj.databinding.entity.UserBean;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-11-02   14:10
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class CustomClassNameActivity extends AppCompatActivity {
    private CustomClassNameBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_bind_class_name);
        binding.setUser(new UserBean("王五","四川省成都市"));
    }
}
