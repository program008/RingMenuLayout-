package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by LiuTao008
 * on 2016/4/13.
 */
public class CarRenewalRefusedActivity extends BaseActivity {
    @ViewInject(R.id.home_car_accidents_buy_xubao_next_tv)
    private TextView nextTv;
    @Override
    protected int getLayout() {
        return R.layout.activity_car_accidents_inform_xubao;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);
        nextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(CarRenewalRefusedActivity.this,CarRenewalRefusedNextActivity.class);
                startActivity(intent1);
                finish();
            }
        });

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }
}
