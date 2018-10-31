package com.ren.databinding.activity.data;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ren.databinding.R;
import com.ren.databinding.component.MyBindingAdapter;
import com.ren.databinding.databinding.ActivityDataTwoWayBinding;
import com.ren.databinding.entity.TwoWayBean;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-31   10:03
 * <p>
 * 描述：双向绑定注意，如果 {@link MyBindingAdapter} 中不注释掉 {@code setText(TextView view,String value)} 方法，就需要对view 如果是EditText时做特殊处理，
 * 增加文字改变监听，防止出现死循环
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class DataTwoWayActivity extends AppCompatActivity {
    private ActivityDataTwoWayBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_two_way);

        binding.setTwoWayBean(new TwoWayBean());
    }
}
