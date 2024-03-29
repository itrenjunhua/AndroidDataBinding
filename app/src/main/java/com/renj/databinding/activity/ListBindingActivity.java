package com.renj.databinding.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.renj.databinding.R;
import com.renj.databinding.databinding.ActivityBindingListBinding;
import com.renj.databinding.utils.RecyclerUtils;

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
public class ListBindingActivity extends AppCompatActivity {
    private ActivityBindingListBinding binding;
    private ObservableList<String> dataList = new ObservableArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        MyAdapter myAdapter = new MyAdapter();

        binding.setAdapter(myAdapter);
        dataList.addOnListChangedCallback(RecyclerUtils.getListChangedCallback(myAdapter));

        for (int i = 0; i < 20; i++) {
            dataList.add("list item value -> " + i);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    dataList.add("list item value add -> " + i);
                }
            }
        }, 800);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ViewDataBinding itemBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_binding_list_item, parent, false);
            return new MyViewHolder(itemBinding.getRoot(), itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ViewDataBinding viewDataBinding = holder.getViewDataBinding();
            viewDataBinding.setVariable(BR.itemValue, dataList.get(position));
            viewDataBinding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding viewDataBinding;

        public MyViewHolder(View itemView, ViewDataBinding viewDataBinding) {
            super(itemView);
            this.viewDataBinding = viewDataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }
    }
}
