package com.hczh.carownercoming.other.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.adapter.GuideAdapter;
import com.hczh.carownercoming.other.utils.Constant;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuTao008
 * on 2016/4/18.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener{
    @ViewInject(R.id.guide_vp)
    private ViewPager viewPager;
    @ViewInject(R.id.gui_jump_button)
    private TextView jumpBtn;
    private GuideAdapter adapter;
    private List<ImageView> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ViewUtils.inject(this);

        //初始化控件
        initView();
        //初始化数据
        initData();

        adapter = new GuideAdapter(imageList);
        viewPager.setAdapter(adapter);
        //给viewpager设置监听器
        viewPager.addOnPageChangeListener(this);
        //给跳转按钮设置监听
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到主界面
                Intent intent = new Intent(GuideActivity.this,MainActivity0.class);
                startActivity(intent);
                GuideActivity.this.finish();
                SharedPreferences sp = getSharedPreferences(Constant.FRIST_TIME_FILE, MODE_PRIVATE);
                sp.edit().putBoolean(Constant.FRIST_TIME_OPEN, false).commit();

            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.guide_vp);
        jumpBtn = (TextView)findViewById(R.id.gui_jump_button);
    }

    private void initData() {
        imageList = new ArrayList<>();
        int[] images = new int[]{
                R.drawable.guide1,
                R.drawable.guide2,
                R.drawable.guide3,
                R.drawable.guide4
        };

        for (int i = 0; i <images.length ; i++) {
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(images[i]);
            imageList.add(iv);
        }
    }

    /**
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        if(position == imageList.size()-1){
            jumpBtn.setVisibility(View.VISIBLE);
        }else {
            jumpBtn.setVisibility(View.INVISIBLE);
        }
    }

    /**
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
