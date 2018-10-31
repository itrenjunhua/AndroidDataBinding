package com.ren.databinding.activity.data;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ren.databinding.R;
import com.ren.databinding.databinding.ActivityDataOneWayBinding;
import com.ren.databinding.entity.OneWayBean;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   10:03
 * <p>
 * 描述：单向绑定示例页面
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class DataOneWayActivity extends AppCompatActivity {
    private ActivityDataOneWayBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_one_way);

        OneWayBean oneWayBean = new OneWayBean("Ren", "Junhua", 25);
        binding.setOneWayBean(oneWayBean);
    }
}
