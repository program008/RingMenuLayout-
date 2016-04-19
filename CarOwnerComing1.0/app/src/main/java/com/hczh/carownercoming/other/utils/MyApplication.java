package com.hczh.carownercoming.other.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.mapapi.SDKInitializer;
import com.lidroid.xutils.BitmapUtils;

import cn.smssdk.SMSSDK;

/**
 * Created by LiuTao008
 * on 2016/4/11.
 */
public class MyApplication extends Application {
    public static RequestQueue mRequestQueue;
    public static BitmapUtils mBitmapUtils;
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        SMSSDK.initSDK(this, "fe1bfb1a4914", "8f78874cd5a26a8140e6ff4a6da623f0");
        mRequestQueue = Volley.newRequestQueue(this);
        mBitmapUtils = new BitmapUtils(this);

    }
}
