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
public class CarRenewalRefusedNextActivity extends BaseActivity {
    @ViewInject(R.id.home_car_accidents_buy_xubao_other_company)
    private TextView otherCompanyTv;
    @Override
    protected int getLayout() {
        return R.layout.activity_car_accidents_inform_xubao_next;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);
        otherCompanyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(CarRenewalRefusedNextActivity.this,CarComparisonBuyActivity.class);
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
