package com.renj.databinding;

import android.app.Application;
import android.content.Context;
import android.databinding.DataBindingUtil;

import com.renj.databinding.component.ReleaseBindingComponent;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:58
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class MyApplication extends Application {
    public static boolean isTestComponent = false;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DataBindingUtil.setDefaultComponent(new ReleaseBindingComponent());
    }

    public static Context getContext(){
        return context;
    }
}
