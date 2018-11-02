package com.renj.databinding.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingConvertersBinding;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   10:03
 * <p>
 * 描述：自定义转换使用了 自定义类 {@link com.renj.databinding.conversters.ColorToColorDrawableConverter}，
 * 将 {@code int} 类型的 {@link android.graphics.Color} 转换为 {@link ColorDrawable}
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ConvertersActivity extends AppCompatActivity {
    private ActivityBindingConvertersBinding binding;

    private boolean status = true;
    public final ObservableArrayMap<String, String> observableArrayMap = new ObservableArrayMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_converters);

        observableArrayMap.put("key0", "value0");
        observableArrayMap.put("key1", "value1");
        observableArrayMap.put("key2", "value2");

        binding.setMap(observableArrayMap);
        binding.setPresenter(new Presenter());
        binding.setStatus(status);
    }

    public class Presenter {
        public void changeColor(View view) {
            status = !status;
            binding.setStatus(status);

            Drawable background = binding.viewConverter.getBackground();
            if (background != null) {
                int color = 0;
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) (background)).getColor();
                }
                binding.setBackground("class: " + background.getClass().getSimpleName() + "  ;color value: " + color);
            }

        }
    }
}
