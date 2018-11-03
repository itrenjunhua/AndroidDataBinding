package com.renj.databinding.activity.custom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingAdapterBinding;
import com.renj.databinding.entity.ImagesUrl;

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
public class BindingAdapterActivity extends AppCompatActivity {
    private ActivityBindingAdapterBinding binding;
    private int totalCount = ImagesUrl.imagesUrl.length;
    private int currentIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_binding_adapter);

        binding.setPresenter(new Presenter());
        binding.setUrl(ImagesUrl.imagesUrl[currentIndex % totalCount]);
        currentIndex += 1;
    }

    public class Presenter{
        public void click(View view){
            binding.setUrl(ImagesUrl.imagesUrl[currentIndex % totalCount]);
            currentIndex += 1;
        }
    }
}
