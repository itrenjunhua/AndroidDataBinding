package com.renj.databinding.activity.data;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityDataObservableBinding;
import com.renj.databinding.entity.OneWayBean;

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
public class ObservableXxxActivity extends AppCompatActivity {
    private ActivityDataObservableBinding binding;

    private final ObservableMap<String,String> observableMap = new ObservableArrayMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_observable);

        observableMap.put("firstName","Zhang");
        observableMap.put("lastName","San");
        binding.setObservableMap(observableMap);

        OneWayBean oneWayBean = new OneWayBean();
        oneWayBean.oString.set("ObservableField<String>");
        oneWayBean.oInt.set(1111);
        binding.setOneWayBean(oneWayBean);
    }
}
