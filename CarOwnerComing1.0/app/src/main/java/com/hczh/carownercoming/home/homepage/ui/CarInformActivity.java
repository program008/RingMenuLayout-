package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseActivity;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 点击首页的车险购买进入的车的详细信息activity
 * Created by LiuTao008
 * on 2016/4/13.
 */
public class CarInformActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.car_information_next_text)
    private TextView nextTv;//下一步
    @ViewInject(R.id.car_information_user_type_rg)
    private RadioGroup userTypeRg;//用户类型
    private boolean isRb1;
    private boolean isRb2;
    @Override
    protected int getLayout() {
        return R.layout.activity_car_information;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        setTitleText(title);
        nextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent1 = new Intent(CarInformActivity.this,CarNoCardsActivity.class);
                startActivity(intent1);*/
              /*  Intent intent1 = new Intent(CarInformActivity.this,CarRenewalRefusedActivity.class);
                startActivity(intent1);*/
                if(isRb2){
                    Intent intent1 = new Intent(CarInformActivity.this,CarNoCardsActivity.class);
                    startActivity(intent1);
                    finish();
                }
                if(isRb1){
                    Intent intent2 = new Intent(CarInformActivity.this,CarRenewalRefusedActivity.class);
                    startActivity(intent2);
                    finish();
                }

            }
        });

    }

    @Override
    protected void initEvents() {
        userTypeRg.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    /**
     * 用户类型的选则的监听器
     * @param radioGroup
     * @param i
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton childAt1 = (RadioButton) radioGroup.getChildAt(0);
        RadioButton childAt2 = (RadioButton) radioGroup.getChildAt(1);
        isRb1 = childAt1.isChecked();
        isRb2 = childAt2.isChecked();

        LogUtil.d("hczh1",isRb1+", "+isRb2);

    }
}
