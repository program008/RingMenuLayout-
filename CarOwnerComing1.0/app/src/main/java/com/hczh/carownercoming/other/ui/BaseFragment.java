package com.hczh.carownercoming.other.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LiuTao008
 * on 2016/3/31.
 */
public abstract class BaseFragment extends Fragment {

    protected View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = inflater.inflate(getLayout(), container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initEvents();
        initData();
    }

    /**
     * 获取布局
     * @return
     */
    protected abstract int getLayout();
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract void initData();


}
