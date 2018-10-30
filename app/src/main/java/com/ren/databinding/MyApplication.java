package com.ren.databinding;

import android.app.Application;

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

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
