package com.renj.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingViewStubBinding;
import com.renj.databinding.databinding.ViewStubLayoutBinding;
import com.renj.databinding.entity.UserBean;

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
public class ViewStubBindingActivity extends AppCompatActivity {
    private ActivityBindingViewStubBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_view_stub);

        // 设置监听，控件显示完成之后绑定数据
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                // ViewStub 使用 DataBindingUtil 的方式
                ViewStubLayoutBinding viewStubLayoutBinding = DataBindingUtil.bind(inflated);
                viewStubLayoutBinding.setUser(new UserBean("李四", "湖南省长沙市"));
            }
        });

        // 显示 ViewStub 控件
        binding.viewStub.getViewStub().inflate();
    }
}
