package com.ren.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ren.databinding.MyApplication;
import com.ren.databinding.R;
import com.ren.databinding.activity.data.BaseObservableActivity;
import com.ren.databinding.activity.data.DataOneWayActivity;
import com.ren.databinding.activity.data.DataTwoWayActivity;
import com.ren.databinding.activity.data.ObservableXxxActivity;
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
public class DataBindingActivity extends AppCompatActivity {
    private ActivityBindingDataBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_data, MyApplication.isTestComponent ? new TestBindingComponent() : new ReleaseBindingComponent());

        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void openBindingOneWayActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, DataOneWayActivity.class));
        }

        public void openBindingTwoWayActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, DataTwoWayActivity.class));
        }

        public void openBaseObservableActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, BaseObservableActivity.class));
        }

        public void openObservableActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, ObservableXxxActivity.class));
        }
    }
}
