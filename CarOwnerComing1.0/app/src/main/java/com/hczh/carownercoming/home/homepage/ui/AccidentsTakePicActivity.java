package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;
import com.hczh.carownercoming.R;
import com.hczh.carownercoming.home.homepage.adapter.ItemAccidentsTakepicGvAdapter;
import com.hczh.carownercoming.other.ui.BaseActivity;
import com.hczh.carownercoming.other.utils.CustomAlertDialog;
import com.hczh.carownercoming.other.utils.GridViewForScrollView;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出险拍照
 * Created by LiuTao008
 * on 2016/4/12.
 */
public class AccidentsTakePicActivity extends BaseActivity implements View.OnClickListener{

    @ViewInject(R.id.home_car_accidents_confirm_baoan_duty1)
    private TextView baoan1Tv;
    @ViewInject(R.id.home_car_accidents_confirm_baoan_duty2)
    private TextView baoan2Tv;
    @ViewInject(R.id.home_car_accidents_confirm_baoan_duty3)
    private TextView baoan3Tv;
    int REQUEST_CODE=1; //用来标识跳到哪个activity的
    private List<Map<String,String>> dutyLists1 = new ArrayList<>();
    private List<Map<Integer, String>> dutyLists2 = new ArrayList<>();
    private List<Map<String,String>> dutyLists3 = new ArrayList<>();
   @ViewInject(R.id.home_car_accidents_confirm_baoan_fl)
    private FrameLayout baoanFl;//报案fl
    private Fragment[] fragments;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_accidents_takepic;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this);

    }

    @Override
    protected void initEvents() {
        baoan1Tv.setOnClickListener(this);
        baoan2Tv.setOnClickListener(this);
        baoan3Tv.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        initFragments();
    }

    /**
     * 创建fragment
     */
    private void initFragments() {
        fragments = new Fragment[]{new TakePic1Fragment(),new TakePic2Fragment(),new TakePic3Fragment()};
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.home_car_accidents_confirm_baoan_fl, fragments[0]);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.home_car_accidents_confirm_baoan_duty1:
                transaction.replace(R.id.home_car_accidents_confirm_baoan_fl,fragments[0]);
                //transaction.addToBackStack(null);
                break;
            case R.id.home_car_accidents_confirm_baoan_duty2:
                transaction.replace(R.id.home_car_accidents_confirm_baoan_fl, fragments[1]);
               // transaction.addToBackStack(null);
                break;
            case R.id.home_car_accidents_confirm_baoan_duty3:
                transaction.replace(R.id.home_car_accidents_confirm_baoan_fl,fragments[2]);
                //如果责任不明确建议先打110报警
                CustomAlertDialog dialog = new CustomAlertDialog(this);
                dialog.setTitle("温馨提示");
                dialog.setMessage("由于事故责任不明，我们建议您先报警，再进行出险拍照，拍照完成后，工作人员会尽快与您联系，全体工作人员将竭诚为您服务！\n" +
                        "注：如需报警请点击确定，点击取消将直接进行拍照。");
                //transaction.addToBackStack(null);
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
