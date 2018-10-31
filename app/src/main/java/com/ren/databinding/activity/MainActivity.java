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
        public void openDataBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
        }

        public void openEventBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, EventBindingActivity.class));
        }

        public void openCollectionBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, CollectionBindingActivity.class));
        }

        public void openListBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ListBindingActivity.class));
        }

        public void openIncludeBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, IncludeBindingActivity.class));
        }

        public void openViewStubBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ViewStubBindingActivity.class));
        }

        public void openBindingAdapterActivity(View view) {
            startActivity(new Intent(MainActivity.this, BindingAdapterActivity.class));
        }

        public void openBindingMethodsActivity(View view) {
            startActivity(new Intent(MainActivity.this, BindingMethodsActivity.class));
        }

        public void openConvertersBindingActivity(View view) {
            startActivity(new Intent(MainActivity.this, ConvertersActivity.class));
        }

        public void changeComponent(View view) {
//            DataBindingUtil.setDefaultComponent(MyApplication.isTestComponent ? new TestBindingComponent() : new TestBindingComponent());
            MyApplication.isTestComponent = !MyApplication.isTestComponent;
            recreate();
        }
    }
}
