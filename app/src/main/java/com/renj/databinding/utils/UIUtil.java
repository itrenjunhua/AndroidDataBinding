package com.renj.databinding.utils;

import android.content.Context;
import android.widget.Toast;

import com.renj.databinding.MyApplication;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-11-05   10:09
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class UIUtil {

    private static Toast toast;

    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static void showToast(String msg) {
        if (toast == null)
            toast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);

        toast.setText(msg);
        toast.show();
    }
}
