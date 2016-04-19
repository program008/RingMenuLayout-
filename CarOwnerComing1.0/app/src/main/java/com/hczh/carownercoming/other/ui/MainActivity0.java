package com.hczh.carownercoming.other.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.home.aboutwe.ui.AboutWeFragment;
import com.hczh.carownercoming.home.cscentre.ui.CsCentreFragment;
import com.hczh.carownercoming.home.homepage.ui.HomePageFragment;
import com.hczh.carownercoming.home.personalcentre.ui.PersonalCentreFragment;
import com.hczh.carownercoming.other.adapter.HomeAdapter;
import com.hczh.carownercoming.other.utils.Constant;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity0 extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @ViewInject(R.id.home_vp)
    private ViewPager homeVp;
    @ViewInject(R.id.home_navigation_rg)
    private RadioGroup homeRg;

    private List<Fragment> fragments;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //如果是第一次打开app则跳入到引导页
        // TODO: 2016/4/11  进入引导页
        if(isFrist()){
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();
        }else {
            //如果不是第一次打开app则直接进入主页
            setContentView(R.layout.activity_main01);
            ViewUtils.inject(this);
            initFragments();
            adapter = new HomeAdapter(getSupportFragmentManager(),fragments);
            homeVp.setAdapter(adapter);
            homeVp.addOnPageChangeListener(this);
            homeRg.setOnCheckedChangeListener(this);
        }

    }

    /**
     * 初始化首页的fragment
     */
    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new CsCentreFragment());
        fragments.add(new PersonalCentreFragment());
        fragments.add(new AboutWeFragment());
        RadioButton homeRb = (RadioButton) homeRg.getChildAt(0);
        homeRb.setChecked(true);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当页面被选中的时候调用
     * @param position
     */
    @Override
    public void onPageSelected(int position) {

        LogUtil.d("hczhhome",position+"");
        RadioButton homeRb = (RadioButton) homeRg.getChildAt(position);
        homeRb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 首页底部导航的监听器，点击切换界面
     * @param radioGroup
     * @param i
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        LogUtil.d("hczhhome1",i+", "+radioGroup.getId());
        switch (i){
            case R.id.home_navigation_home:
                homeVp.setCurrentItem(0);
                break;
            case R.id.home_navigation_kfzx:
                homeVp.setCurrentItem(1);
                break;
            case R.id.home_navigation_grzx:
                homeVp.setCurrentItem(2);
                break;
            case R.id.home_navigation_gywm:
                homeVp.setCurrentItem(3);
                break;
            default:
                break;

        }
    }


    /**
     *
     * @return
     */
    private boolean isFrist() {
        SharedPreferences fristTime = getSharedPreferences(Constant.FRIST_TIME_FILE, MODE_PRIVATE);
        boolean isFrist = fristTime.getBoolean(Constant.FRIST_TIME_OPEN, true);
        return isFrist;
    }
}
