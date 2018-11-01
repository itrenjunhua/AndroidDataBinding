package com.renj.databinding.component;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * 邮箱：renjunhua@anlovek.com
 * <p>
 * 创建时间：2018-10-30   18:35
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class TestBindingComponent implements android.databinding.DataBindingComponent {
    private MyBindingAdapter bindingAdapter = new TestBindingAdapter();

    @Override
    public MyBindingAdapter getMyBindingAdapter() {
        return bindingAdapter;
    }
}
