package com.renj.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renj.databinding.MyApplication;
import com.renj.databinding.R;
import com.renj.databinding.component.ReleaseBindingComponent;
import com.renj.databinding.component.TestBindingComponent;
import com.renj.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main, MyApplication.isTestComponent ? new TestBindingComponent() : new ReleaseBindingComponent());

        activityMainBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        // 数据绑定示例页面
        public void openDataBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
        }

        // 事件绑定示例页面
        public void openEventBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, EventBindingActivity.class));
        }

        // 使用DataBinding集合示例页面
        public void openCollectionBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, CollectionBindingActivity.class));
        }

        // 列表数据使用DataBinding示例页面
        public void openListBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ListBindingActivity.class));
        }

        // Include标签使用DataBinding示例页面
        public void openIncludeBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, IncludeBindingActivity.class));
        }

        // ViewStub控件使用DataBinding示例页面
        public void openViewStubBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ViewStubBindingActivity.class));
        }

        // 自定义属性绑定
        public void openCustomBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, CustomBindingActivity.class));
        }

        // 导包和定义别名示例页面
        public void openImportActivity(View view){
            startActivity(new Intent(MainActivity.this, ImportActivity.class));
        }

        // 自定义Binding类名示例页面
        public void openCustomClassNameActivity(View view){
            startActivity(new Intent(MainActivity.this, CustomClassNameActivity.class));
        }

        // Converters/转换示例页面
        public void openConvertersBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ConvertersActivity.class));
        }

        // 修改 Component，修改的是所有的在 xml 用 DataBinding 形式绑定的属性并且在 Component 中的 XxxAdapter 中处理的属性
        public void changeComponent(View view) {
            DataBindingUtil.setDefaultComponent(MyApplication.isTestComponent ? new ReleaseBindingComponent() : new TestBindingComponent());
            MyApplication.isTestComponent = !MyApplication.isTestComponent;
            recreate();
        }
    }
}
