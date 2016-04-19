package com.hczh.carownercoming.other.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hczh.carownercoming.R;

/**
 * Created by LiuTao008
 * on 2016/4/6.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private LinearLayout contentLl;
    private TextView leftBackTv;
    private TextView centerTileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        contentLl = (LinearLayout) findViewById(R.id.base_content_ll);

        leftBackTv = (TextView) findViewById(R.id.activity_base_back_left_iv);
        centerTileTv = (TextView) findViewById(R.id.activity_base_title_center_iv);

        setDefaultEvent();
        getLayoutInflater().inflate(getLayout(), contentLl);
        initViews();
        initEvents();
        initData();
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化布局
     */
    protected abstract void initViews();

    /**
     * 初始化事件
     */
    protected abstract void initEvents();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置左边的返回图标的默认监听事件
     */
    private void setDefaultEvent() {
        leftBackTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.this.overridePendingTransition( R.anim.activity_close_exit,R.anim.activity_close_enter);

            }
        });
    }

    protected void setTitleText(String title) {
        centerTileTv.setVisibility(View.VISIBLE);
        centerTileTv.setText(title);
    }


}


