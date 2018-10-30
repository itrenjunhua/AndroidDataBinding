package com.ren.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ren.databinding.MyApplication;
import com.ren.databinding.R;
import com.ren.databinding.component.ReleaseBindingComponent;
import com.ren.databinding.component.TestBindingComponent;
import com.ren.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main, MyApplication.isTestComponent ? new TestBindingComponent() : new ReleaseBindingComponent());

        activityMainBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void openBindingDataActivity(View view) {
            startActivity(new Intent(MainActivity.this, BindingDataActivity.class));
        }

        public void changeComponent(View view) {
//            DataBindingUtil.setDefaultComponent(MyApplication.isTestComponent ? new TestBindingComponent() : new TestBindingComponent());
            MyApplication.isTestComponent = !MyApplication.isTestComponent;
            recreate();
        }
    }
}
