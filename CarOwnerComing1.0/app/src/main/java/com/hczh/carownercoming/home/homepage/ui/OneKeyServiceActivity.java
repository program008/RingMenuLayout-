package com.hczh.carownercoming.home.homepage.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 一键服务
 * Created by LiuTao008
 * on 2016/4/14.
 */
public class OneKeyServiceActivity extends BaseActivity implements View.OnClickListener {
    @ViewInject(R.id.home_onekey_service_call_number_ll)
    private LinearLayout call1Ll;//拨号
    @ViewInject(R.id.home_onekey_service_call_ring)
    private TextView call2Tv;//正在呼叫。。
    @ViewInject(R.id.home_onekey_service_hanguping_tv)
    private TextView call3Tv;//已挂断
    @ViewInject(R.id.home_onekey_service_dialing_tv)
    private TextView callNumTv;//拨号
    @ViewInject(R.id.home_onekey_service_hangup_tv)
    private TextView hangupTv;//挂断

    @Override
    protected int getLayout() {
        return R.layout.activity_home_onekey_service;
    }

    @Override
    protected void initViews() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        setTitleText(title);
        ViewUtils.inject(this);
        call1Ll.setVisibility(View.VISIBLE);
        call2Tv.setVisibility(View.GONE);
        call3Tv.setVisibility(View.GONE);
    }

    @Override
    protected void initEvents() {
        callNumTv.setOnClickListener(this);
        hangupTv.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_onekey_service_dialing_tv:
                call1Ll.setVisibility(View.GONE);
                call2Tv.setVisibility(View.VISIBLE);
                call3Tv.setVisibility(View.GONE);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:4008208820"));

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
            case R.id.home_onekey_service_hangup_tv:
                call1Ll.setVisibility(View.GONE);
                call2Tv.setVisibility(View.GONE);
                call3Tv.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
