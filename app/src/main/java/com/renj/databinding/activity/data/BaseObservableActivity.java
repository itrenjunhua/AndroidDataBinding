package com.renj.databinding.activity.data;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityDataBaseObservableBinding;
import com.renj.databinding.entity.TwoWayBean;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   10:08
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class BaseObservableActivity extends AppCompatActivity {
    private ActivityDataBaseObservableBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_base_observable);

        binding.setTwoWayBean(new TwoWayBean("Ren","Junhua"));
    }
}
