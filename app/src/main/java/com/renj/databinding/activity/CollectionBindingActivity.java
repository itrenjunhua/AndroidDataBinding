package com.renj.databinding.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingCollectionBinding;

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
public class CollectionBindingActivity extends AppCompatActivity {
    private ActivityBindingCollectionBinding binding;

    private final ObservableArrayList<String> observableArrayList = new ObservableArrayList<>();
    private final ObservableArrayMap<String, String> observableArrayMap = new ObservableArrayMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_collection);

        observableArrayList.add("String Data -> 0");
        observableArrayList.add("String Data -> 1");
        observableArrayList.add("String Data -> 2");
        observableArrayList.add("String Data -> 3");

        observableArrayMap.put("key0", "value0");
        observableArrayMap.put("key1", "value1");
        observableArrayMap.put("key2", "value2");
        observableArrayMap.put("key3", "value3");

        binding.setObservableArrayList(observableArrayList);
        binding.setObservableArrayMap(observableArrayMap);
    }
}
