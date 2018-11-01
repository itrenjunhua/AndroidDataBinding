package com.renj.databinding.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingEventBinding;

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
public class EventBindingActivity extends AppCompatActivity {
    private ActivityBindingEventBinding binding;

    private ObservableField<String> btContent = new ObservableField<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_event);

        binding.setPresenter(new Presenter());

        btContent.set("输入内容：");
        binding.setBtContent(btContent);
    }

    public class Presenter {
        public void click(View view) {
            int viewId = view.getId();
            if (viewId == R.id.bt_click1) {
                Toast.makeText(EventBindingActivity.this, "通过id区分事件1", Toast.LENGTH_SHORT).show();
            } else if (viewId == R.id.bt_click2) {
                Toast.makeText(EventBindingActivity.this, "通过id区分事件2", Toast.LENGTH_SHORT).show();
            }
        }

        public void clickMethod1(View view) {
            Toast.makeText(EventBindingActivity.this, "调用单个方法1", Toast.LENGTH_SHORT).show();
        }

        public void clickMethod2(View view) {
            Toast.makeText(EventBindingActivity.this, "调用单个方法2", Toast.LENGTH_SHORT).show();
        }

        public void lambdaMethod(View view) {
            Toast.makeText(EventBindingActivity.this, "Lambda表达式方式", Toast.LENGTH_SHORT).show();
        }

        public void paramsMethod(View view, Context context, String params) {
            Toast.makeText(context, params, Toast.LENGTH_SHORT).show();
        }

        public void onEditTextChange(Editable editable) {
            btContent.set("输入内容：" + editable.toString());
        }
    }
}
