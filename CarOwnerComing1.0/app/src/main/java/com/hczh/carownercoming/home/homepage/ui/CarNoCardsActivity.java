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
public class CarNoCardsActivity extends BaseActivity {
    @ViewInject(R.id.home_car_accidents_buy_notcards_next_tv)
    private TextView nextTv;
    @Override
    protected int getLayout() {
        return R.layout.activity_car_accidents_inform_notcards;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);
        nextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarNoCardsActivity.this,CarComparisonBuyActivity.class);
                startActivity(intent);
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
