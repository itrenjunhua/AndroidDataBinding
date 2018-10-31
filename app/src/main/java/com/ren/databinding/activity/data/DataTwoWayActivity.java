package com.ren.databinding.activity.data;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ren.databinding.R;
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
 * 描述：双向绑定注意，如果 {@link com.ren.databinding.component.MyBindingAdapter} 中不注释掉 {@code setText(TextView view,String value)} 方法，
 * 就需要对view 如果是EditText时做特殊处理，增加文字改变监听，防止出现死循环<br/><br/>
 * 目前Android支持的双向绑定控件： <br/>
 * {@code AbsListView android:selectedItemPosition} <br/>
 * {@code CalendarView android:date} <br/>
 * {@code CompoundButton android:checked} <br/>
 * {@code DatePicker android:year, android:month, android:day} <br/>
 * {@code NumberPicker android:value} <br/>
 * {@code RadioGroup android:checkedButton} <br/>
 * {@code RatingBar android:rating} <br/>
 * {@code SeekBar android:progress} <br/>
 * {@code TabHost android:currentTab} <br/>
 * {@code TextView android:text} <br/>
 * {@code TimePicker android:hour, android:minute} <br/>
 * 当然，其他的控件也可以使用 {@link android.databinding.InverseBindingAdapter} 、 {@link android.databinding.InverseBindingMethods} 自定义双向绑定。
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
