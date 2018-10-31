package com.ren.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ren.databinding.R;
import com.ren.databinding.activity.data.BaseObservableActivity;
import com.ren.databinding.activity.data.DataOneWayActivity;
import com.ren.databinding.activity.data.DataTwoWayActivity;
import com.ren.databinding.activity.data.MyTwoWayActivity;
import com.ren.databinding.activity.data.ObservableXxxActivity;
import com.ren.databinding.databinding.ActivityBindingDataBinding;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:43
 * <p>
 * 描述：数据绑定Activity
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_data);

        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        // 单向绑定
        public void openBindingOneWayActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, DataOneWayActivity.class));
        }

        // 双向绑定
        public void openBindingTwoWayActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, DataTwoWayActivity.class));
        }

        // 绑定对象继承 BaseObservable
        public void openBaseObservableActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, BaseObservableActivity.class));
        }

        // 部分字段 ObservableXxx
        public void openObservableActivity(View view) {
            startActivity(new Intent(DataBindingActivity.this, ObservableXxxActivity.class));
        }

        // 自定义双向绑定
        public void openMyTwoWayActivity(View view){
            startActivity(new Intent(DataBindingActivity.this, MyTwoWayActivity.class));
        }
    }
}
