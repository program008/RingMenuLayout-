package com.hczh.carownercoming.other.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by LiuTao008
 * on 2016/4/15.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    @ViewInject(R.id.user_loginui_account_edit)
    private EditText loginAccount;//账号
    @ViewInject(R.id.user_loginui_check_code_tv)
    private TextView checkCode;//获取密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewUtils.inject(this);
        checkCode.setOnClickListener(this);

        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        //提交验证码成功
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "获取验证码成功", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
                // 提交用户信息
                //registerUser(country, phone);
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_loginui_check_code_tv:
                SMSSDK.getVerificationCode("86", loginAccount.getText().toString());

                LogUtil.d("qfregister", loginAccount.getText().toString());
                break;
            default:
                break;


        }
    }


}
