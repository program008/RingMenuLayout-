package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.google.gson.Gson;
import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.bean.Weather;
import com.hczh.carownercoming.other.ui.BaseFragment;
import com.hczh.carownercoming.other.ui.CircleActivity;
import com.hczh.carownercoming.other.ui.LoginActivity;
import com.hczh.carownercoming.other.ui.MainActivity;
import com.hczh.carownercoming.other.utils.CircleMenuLayout;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.hczh.carownercoming.other.utils.MyApplication;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

/**
 * 首页
 * Created by LiuTao008
 * on 2016/4/11.
 */
public class HomePageFragment extends BaseFragment implements View.OnClickListener, BDLocationListener {

    @ViewInject(R.id.home_weather_temperature)
    private TextView temperatureTv;//温度
    @ViewInject(R.id.home_weather_cityname)
    private TextView citynameTv;//城市名
    @ViewInject(R.id.home_weather_is_washcar)
    private TextView isWashCar;//是否适合洗车

    @ViewInject(R.id.beijingshang2)
    private ImageView bgshang;//背景上
    @ViewInject(R.id.home_page_login_iv)
    private TextView loginIv;//登录
    @ViewInject(R.id.home_page_fixed_position_tv)
    private TextView fixedPositionTv;//定位
    @ViewInject(R.id.home_page_take_picture_rl)
    private RelativeLayout takePicRl;//拍照出险
    @ViewInject(R.id.home_horizontal_srollView)
    private LinearLayout scrollView;
    @ViewInject(R.id.beijingshang2)
    private ImageView beijingHeadIv;//背景盖层上
    private Boolean isFrist = true;

    private LocationClientOption options;
    private LocationClient locationClient;
    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] { "车险计算 ", "洗车养车",
            "一键服务", "限号查询", "违章查询" ,"道路救援","积分商城","理赔进度","维修进度","车辆审核"};
    private int[] mItemImgs = new int[] { R.drawable.chexianjisuan,
            R.drawable.yangchexiche, R.drawable.yijianfuwu,
            R.drawable.xianhaochaxun, R.drawable.weizhangchaxun,
            R.drawable.daolujiuyuan, R.drawable.jifenshangcheng,
            R.drawable.lipeijindu, R.drawable.weixiujindu,
            R.drawable.cheliangshenhe };

    @Override
    protected int getLayout() {
        return R.layout.fragment_homepage;
    }


    @Override
    protected void initViews() {
        ViewUtils.inject(this, root);
        mCircleMenuLayout = (CircleMenuLayout) root.findViewById(R.id.home_circle_menu_ll);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        if(isFrist){
            //第一次滚动后后有背景
            beijingHeadIv.setVisibility(View.GONE);
            isFrist = false;
        }else {
            beijingHeadIv.setVisibility(View.VISIBLE);
        }

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        mCircleMenuLayout.startAnimation(animation);
        beijingHeadIv.setVisibility(View.VISIBLE);





        bgshang.setOnClickListener(null);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {
                Intent intent = null;
                switch (pos){
                    //"车险计算 ", "洗车养车",
                    //"一键服务", "限号查询", "违章查询" ,"道路救援","积分商城",
                            //"理赔进度","维修进度","车辆审核"
                    case 0:
                        intent = new Intent(getActivity(),CarInformActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(),WashCarActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(),OneKeyServiceActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //"限号查询"
                        intent = new Intent(getActivity(),LimitedNumberQueryActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        //"违章查询"
                        intent = new Intent(getActivity(),PeccancyQueryActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        //"道路救援"
                        intent = new Intent(getActivity(),RoadRescueActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        //"积分商城",
                        intent = new Intent(getActivity(),IntegralMallActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        //"理赔进度"
                        intent = new Intent(getActivity(),LipeiProgressActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        //"维修进度"
                        intent = new Intent(getActivity(),MaintainScheduleActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        //"车辆审核"
                        intent = new Intent(getActivity(),CarCheckActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
                getActivity().overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_open_exit);


            }

            @Override
            public void itemCenterClick(View view) {


            }
        });


        options = new LocationClientOption();
        initLoation();
        locationClient = new LocationClient(getActivity().getApplicationContext(),options);
        locationClient.registerLocationListener(this);
        getWeatherInform("贵阳");


        //循环更换button的背景颜色
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.activity_open_enter1);
                Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.activity_open_exit2);
                Animation animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.activity_close_enter);
                Animation animation4 = AnimationUtils.loadAnimation(getActivity(), R.anim.activity_close_exit);

                //0-100. 100,-100,-100,0,
                //scrollView.startAnimation(animation3);
                scrollView.startAnimation(animation1);
                scrollView.startAnimation(animation2);

                handler.postDelayed(this, 10000);

            }
        }, 500);

    }

    @Override
    protected void initEvents() {

        loginIv.setOnClickListener(this);
        fixedPositionTv.setOnClickListener(this);
        takePicRl.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    /**
     * 定位的配置信息
     */
    private void initLoation() {
        /**
         * 配置定位模式
         * 高精度：LocationClientOption.LocationMode.Hight_Accuracy
         * 低功耗：LocationClientOption.LocationMode.Battery_Saving
         * 设备：LocationClientOption.LocationMode.Device_Sensors
         */
        options.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        // 设置定位结果返回的坐标系
        // coorType - 取值有3个：
        // 返回国测局经纬度坐标系：gcj02
        // 返回百度墨卡托坐标系 ：bd09
        // 返回百度经纬度坐标系 ：bd09ll
        options.setCoorType("bd09ll");
        // 设置发起定位的间隔时间，默认为0，仅定位一次，需要大于等于1000ms才有效
        options.setScanSpan(1000);
        // 设置返回信息包含地址信息
        options.setIsNeedAddress(true);
        // 打开GPS 默认关闭
        options.setOpenGps(true);
        //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        options.setLocationNotify(true);

    }
    /**
     * 首页的控件的点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.home_page_fixed_position_tv://定位
                LogUtil.d("location", "开始定位");
                locationClient.start();
                break;
            case R.id.home_page_login_iv://登录
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.home_page_take_picture_rl://登录
                intent = new Intent(getActivity(),AccidentsTakePicActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
        getActivity().overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_open_exit);
    }

    /**
     * 获取天气
     * @param cityName
     */
    private void  getWeatherInform(final String cityName) {
        //阿凡達数据
        //http://api.avatardata.cn/Weather/Query?key=0e3f2d6720204d7699a7937c206bfc03&cityname=%E8%B4%B5%E9%98%B3
        String urlStr = null;
        try {
            urlStr = URLEncoder.encode(cityName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://api.avatardata.cn/Weather/Query?key=0e3f2d6720204d7699a7937c206bfc03&cityname="+urlStr;

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       LogUtil.d("hczhweather","天气 "+response+"");
                        Gson gson = new Gson();
                        Weather weather = gson.fromJson(response, Weather.class);
                        Weather.ResultEntity result = weather.getResult();
                        if(result!=null){
                            Weather.ResultEntity.RealtimeEntity realtime = result.getRealtime();
                            Weather.ResultEntity.RealtimeEntity.WeatherEntity weather1 = realtime.getWeather();
                            String temperature = weather1.getTemperature();

                            Weather.ResultEntity.LifeEntity life = result.getLife();
                            Weather.ResultEntity.LifeEntity.InfoEntity info = life.getInfo();
                            List<String> xiche = info.getXiche();
                            String isXiche = xiche.get(0);
                            if(!TextUtils.isEmpty(temperature)){
                                temperatureTv.setText(temperature+"°");
                            }
                            citynameTv.setText(cityName);
                            isWashCar.setText(isXiche+"洗车");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );
        MyApplication.mRequestQueue.add(request);

    }

    /**
     * 定位监听器
     * @param bdLocation
     */
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
// 获取定位返回的标志
        int type = bdLocation.getLocType();
        // 判断类型
        switch (type){
            case BDLocation.TypeGpsLocation:
            case BDLocation.TypeNetWorkLocation:
            case BDLocation.TypeOffLineLocation:

                double latitude = bdLocation.getLatitude();
                double longitude = bdLocation.getLongitude();
                LatLng latLng = new LatLng(latitude,longitude);
                LogUtil.d("ditu",bdLocation.getAddrStr()+"/"+bdLocation.getAddrStr()+"/ "+
                bdLocation.getCoorType()+"/"+bdLocation.getDistrict()+"/ getFloor /"+bdLocation.getFloor()
                        +"/ getNetworkLocationType/"+
                bdLocation.getNetworkLocationType()+"/ getStreet /"+bdLocation.getStreet());

                LogUtil.d("location",latitude+", "+longitude+", "+bdLocation.getProvince()+","+","+bdLocation.getCity());
                getWeatherInform(bdLocation.getCity());
                break;
            default:
                Toast.makeText(getActivity(), "定位失败：" + type, Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
