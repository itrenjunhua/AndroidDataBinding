package com.renj.databinding.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;

import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingEventBinding;
import com.renj.databinding.utils.UIUtil;

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
                UIUtil.showToast("通过id区分事件1");
            } else if (viewId == R.id.bt_click2) {
                UIUtil.showToast("通过id区分事件2");
            }
        }

        public void clickMethod1(View view) {
            UIUtil.showToast("调用单个方法1");
        }

        public void clickMethod2(View view) {
            UIUtil.showToast("调用单个方法2");
        }

        public void lambdaMethod(View view) {
            UIUtil.showToast("Lambda表达式方式");
        }

        public void paramsMethod(View view, Context context, String params) {
            UIUtil.showToast(params);
        }

        public void onEditTextChange(Editable editable) {
            btContent.set("输入内容：" + editable.toString());
        }
    }
}
