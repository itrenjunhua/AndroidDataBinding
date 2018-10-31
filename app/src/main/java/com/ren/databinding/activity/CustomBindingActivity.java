package com.ren.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ren.databinding.R;
import com.ren.databinding.activity.custom.BindingAdapterActivity;
import com.ren.databinding.activity.custom.BindingInverseAdapterActivity;
import com.ren.databinding.activity.custom.BindingInverseMethodsActivity;
import com.ren.databinding.activity.custom.BindingMethodsActivity;
import com.ren.databinding.databinding.ActivityBindingCustomBinding;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   16:35
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class CustomBindingActivity extends AppCompatActivity {
    private ActivityBindingCustomBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_custom);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        // BindingAdapter/自定义属性示例页面
        public void openBindingAdapterActivity(View view) {
            startActivity(new Intent(CustomBindingActivity.this, BindingAdapterActivity.class));
        }

        // BindingMethods/属性方法映射示例页面
        public void openBindingMethodsActivity(View view) {
            startActivity(new Intent(CustomBindingActivity.this, BindingMethodsActivity.class));
        }

        // BindingInverseAdapter/自定义属性示例页面
        public void openBindingInverseAdapterActivity(View view) {
            startActivity(new Intent(CustomBindingActivity.this, BindingInverseAdapterActivity.class));
        }

        // BindingInverseMethods/属性方法映射示例页面
        public void openBindingInverseMethodsActivity(View view) {
            startActivity(new Intent(CustomBindingActivity.this, BindingInverseMethodsActivity.class));
        }
    }
}
