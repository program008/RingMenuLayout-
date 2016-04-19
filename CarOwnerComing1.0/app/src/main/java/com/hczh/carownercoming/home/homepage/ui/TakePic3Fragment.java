package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseFragment;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.hczh.carownercoming.other.utils.MyApplication;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by LiuTao008
 * on 2016/4/14.
 */
public class TakePic3Fragment extends BaseFragment implements View.OnClickListener {
    @ViewInject(R.id.take_picture_btn1_iv3)
    private ImageView takePicBtn1;
    @ViewInject(R.id.take_picture_btn2_iv3)
    private ImageView takePicBtn2;
    @ViewInject(R.id.take_picture_btn3_iv3)
    private ImageView takePicBtn3;
    @ViewInject(R.id.take_picture_btn4_iv3)
    private ImageView takePicBtn4;

    final int REQUEST_CODE=1; //用来标识跳到哪个activity的
    @Override
    protected int getLayout() {
        return R.layout.fragment_car_accidents_take_pic3;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {
        takePicBtn1.setOnClickListener(this);
        takePicBtn2.setOnClickListener(this);
        takePicBtn3.setOnClickListener(this);
        takePicBtn4.setOnClickListener(this);
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this, root);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==getActivity().RESULT_OK){
            if(data!=null){
                String picName = data.getStringExtra("picName");
                String postion = data.getStringExtra("postion");
                int i = Integer.valueOf(postion);
                LogUtil.d("picName", picName + ", " + i);
                switch (i){
                    case 1:
                        MyApplication.mBitmapUtils.display(takePicBtn1,"/sdcard/" +picName+".jpg");
                        break;
                    case 2:
                        MyApplication.mBitmapUtils.display(takePicBtn2,"/sdcard/" +picName+".jpg");
                        break;
                    case 3:
                        MyApplication.mBitmapUtils.display(takePicBtn3,"/sdcard/" +picName+".jpg");
                        break;
                    case 4:
                        MyApplication.mBitmapUtils.display(takePicBtn4,"/sdcard/" +picName+".jpg");
                        break;
                    default:
                        break;
                }
            }
        }


    }

   /* *
     * 拍照点击事件
     * @param view*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.take_picture_btn1_iv3:
                Intent intent = new Intent(getActivity(),TakePictureActivity.class);
                intent.putExtra("postion",1+"");
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.take_picture_btn2_iv3:
                Intent intent2 = new Intent(getActivity(),TakePictureActivity.class);
                intent2.putExtra("postion",2+"");
                startActivityForResult(intent2,REQUEST_CODE);
                break;
            case R.id.take_picture_btn3_iv3:
                Intent intent3 = new Intent(getActivity(),TakePictureActivity.class);
                intent3.putExtra("postion",3+"");
                startActivityForResult(intent3,REQUEST_CODE);
                break;
            case R.id.take_picture_btn4_iv3:
                Intent intent4 = new Intent(getActivity(),TakePictureActivity.class);
                intent4.putExtra("postion",4+"");
                startActivityForResult(intent4,REQUEST_CODE);
                break;
            default:
                break;
        }
    }


}
