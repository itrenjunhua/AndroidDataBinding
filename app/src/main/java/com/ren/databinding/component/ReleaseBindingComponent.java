package com.ren.databinding.component;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:32
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class ReleaseBindingComponent implements android.databinding.DataBindingComponent {
    private MyBindingAdapter bindingAdapter = new ReleaseBindingAdapter();

    @Override
    public MyBindingAdapter getMyBindingAdapter() {
        return bindingAdapter;
    }
}
