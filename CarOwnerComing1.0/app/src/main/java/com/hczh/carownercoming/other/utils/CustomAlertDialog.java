package com.hczh.carownercoming.other.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hczh.carownercoming.R;

/**
 * Created by LiuTao008
 * on 2016/4/13.
 */
public class CustomAlertDialog {
    Context context;
    android.app.AlertDialog ad;
    TextView titleView;
    TextView messageView;
    LinearLayout buttonLayout;
    private final Window window;

    public CustomAlertDialog(Context context) {
        // TODO Auto-generated constructor stub
        this.context=context;
        ad=new android.app.AlertDialog.Builder(context).create();
        ad.show();
        //关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
        window = ad.getWindow();
      /*  WindowManager.LayoutParams lp = window.getAttributes();
        //window.setGravity(Gravity.LEFT | Gravity.TOP);
        window.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
       *//* lp.width = 300; // 宽度
        lp.height = 300; // 高度*//*
       // lp.alpha = 0.7f; // 透明度
        window.setAttributes(lp);*/

        window.setContentView(R.layout.custom_alertdialog2);
        titleView=(TextView) window.findViewById(R.id.title);
        messageView=(TextView) window.findViewById(R.id.message);
        buttonLayout=(LinearLayout) window.findViewById(R.id.buttonLayout);
    }
    public void setTitle(int resId)
    {
        titleView.setText(resId);
    }
    public void setTitle(String title) {
        titleView.setText(title);
    }
    public void setMessage(int resId) {
        messageView.setText(resId);
    }  public void setMessage(String message)
    {
        messageView.setText(message);
    }

    /**
     * 设置按钮
     * @param text
     * @param listener
     */
    public void setPositiveButton(String text,final View.OnClickListener listener)
    {
        Button button=new Button(context);
        LinearLayout.LayoutParams  params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        button.setLayoutParams(params);
        button.setBackgroundResource(R.drawable.alertdialog_button);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(listener);
        buttonLayout.addView(button);
    }  /**
     * 设置按钮
     * @param text
     * @param listener
     */
    public void setNegativeButton(String text,final View.OnClickListener listener)
    {
        Button button=new Button(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setBackgroundResource(R.drawable.alertdialog_button);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(20);
        button.setOnClickListener(listener);
        if(buttonLayout.getChildCount()>0)
        {
            params.setMargins(20, 0, 0, 0);
            button.setLayoutParams(params);
            buttonLayout.addView(button, 1);
        }else{
            button.setLayoutParams(params);
            buttonLayout.addView(button);
        }  }
    /**
     * 关闭对话框
     */
    public void dismiss() {
        ad.dismiss();
    }

}

