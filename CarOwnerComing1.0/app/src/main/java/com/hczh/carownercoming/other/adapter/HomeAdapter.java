package com.hczh.carownercoming.other.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by LiuTao008
 * on 2016/4/11.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    public HomeAdapter(FragmentManager fm, List lists) {
        super(fm);
        this.lists = lists;
    }

    private List<Fragment> lists;

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}


