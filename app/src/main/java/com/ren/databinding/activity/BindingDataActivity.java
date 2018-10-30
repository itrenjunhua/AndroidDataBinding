package com.ren.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ren.databinding.MyApplication;
import com.ren.databinding.R;
import com.ren.databinding.component.ReleaseBindingComponent;
import com.ren.databinding.component.TestBindingComponent;
import com.ren.databinding.databinding.ActivityBindingDataBinding;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:43
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class BindingDataActivity extends AppCompatActivity {
    private ActivityBindingDataBinding bindingDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding_data,MyApplication.isTestComponent ? new TestBindingComponent() : new ReleaseBindingComponent());

        bindingDataBinding.setPresenter(new Presenter());
    }

    public class Presenter {

    }
}
