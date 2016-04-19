package com.hczh.carownercoming.home.homepage.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseActivity;
import com.hczh.carownercoming.other.utils.CustomAlertDialog;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import junit.framework.Test;

/**
 * Created by LiuTao008
 * on 2016/4/13.
 */
public class CarComparisonBuyActivity extends BaseActivity {
    @ViewInject(R.id.car_information_comparison_buy_tv)
    private TextView okbuyTv;
    @Override
    protected int getLayout() {
        return R.layout.activity_car_comparison_buy;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);
        setTitleText("对比够买");
        okbuyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //如果没有登陆提示用户登陆
                hintInformation();
            }
        });

    }

    /**
     * 自定义对话框
     */
    private void hintInformation() {
       /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        View view = getLayoutInflater().inflate(R.layout.custom_dialog_kindly_reminder,null);
        builder.setView(view);
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();*/

        final CustomAlertDialog ad=new CustomAlertDialog(this);
        ad.setTitle("温馨提示");
        ad.setMessage("尊敬的用户您好，由于您没有登录账号，请登录后在进行购买！");

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }
}
