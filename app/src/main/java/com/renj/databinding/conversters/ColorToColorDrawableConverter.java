package com.renj.databinding.conversters;

import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-11-02   15:31
 * <p>
 * 描述：使用Converter一定要保证它不会影响到其他的属性<br/><br/>
 * 说明：如果定义一个方法，将 {@code int} 转换为 {@code String} <br/>
 * <pre>
 * public static String intToString(int value){
 *     return value + " String";
 * }
 * </pre>
 * 那么，所有的使用DataBinding形式接收的 {@code int} 类型将全部转换为 {@code String} 类型。<br/>
 * 或者：当我们定义了一个从 {@code int} 类型转换为 {@code int} 类型的方法时，那么他能够影响 {@code android:visibility} 属性。<br/>
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ColorToColorDrawableConverter {
    /**
     * 定义一个 Converter ，将 {@code int} 类型的 {@link android.graphics.Color} 转换为 {@link ColorDrawable}
     *
     * @param color
     * @return
     */
    @BindingConversion
    public static ColorDrawable colorToColorDrawable(int color) {
        return new ColorDrawable(color);
    }
}
