package com.hczh.carownercoming.home.homepage.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.utils.CustomAlertDialog;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 拍照相机
 * Created by LiuTao008
 * on 2016/4/12.
 */
public class TakePictureActivity extends AppCompatActivity {
    @ViewInject(R.id.take_picture_switch)
    private ImageView switchIv;//拍照开关的按钮
    @ViewInject(R.id.take_picture_cancel)
    private TextView cancelTv;//取消拍照返回上一个界面
    @ViewInject(R.id.take_picture_surface_iv)
    private ImageView surfaceIv;
    @ViewInject(R.id.take_picture_surface)
    private SurfaceView surfaceView;//拍照区域预览
    private Camera mCamera;
    @ViewInject(R.id.take_picture_help_tv)
    private TextView helpTv;//拍照帮助
    @ViewInject(R.id.take_picture_cancel)
    private TextView backTv;//取消拍摄
    @ViewInject(R.id.take_picture_again)
    private TextView againTv;//重拍
    @ViewInject(R.id.take_picture_ok)
    private TextView okTv;//确定拍摄的照片
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        ViewUtils.inject(this);

        CustomAlertDialog dialog = new CustomAlertDialog(this);
        dialog.setTitle("温馨提示");
        dialog.setMessage("  尊敬的用户，您好，请从相关车辆的车前、车后、车身三个不同的方向拍摄现场照片。");
        switchIv.setVisibility(View.VISIBLE);
        cancelTv.setVisibility(View.VISIBLE);
        surfaceIv.setVisibility(View.VISIBLE);
        againTv.setVisibility(View.GONE);
        okTv.setVisibility(View.GONE);

        surfaceView.getHolder().addCallback(new SfCallback());

    }

    class SfCallback implements SurfaceHolder.Callback {

        /**
         * 设置相机属性
         */
        void setCamera() {
            //得到相机支持的拍照分辨率，按大小排列（有的手机从大到小，有的从小到大）
            List<Camera.Size> listSize = mCamera.getParameters().getSupportedPictureSizes();

            Camera.Parameters parameters = mCamera.getParameters();

            // 从大到小排列的情况下，设置照片的大小，只能设置成支持的size，不能随意设置
            parameters.setPictureSize(listSize.get(0).width, listSize.get(0).height);

            // 设置图片格式
            parameters.setPictureFormat(ImageFormat.JPEG);
            mCamera.setParameters(parameters);

            //默认情况下相机是横向的，这里只是改变预览的方向
            mCamera.setDisplayOrientation(90);
        }


        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            mCamera = Camera.open();
            try {
                setCamera();
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            mCamera.autoFocus(null);
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

            //释放camera
            if (mCamera != null) {
                mCamera.release();
                mCamera = null;
            }
        }
    }

    /**
     * 旋转照片
     *
     * @param bmSrc
     */
    public Bitmap RotateBitmap(Bitmap bmSrc) {
        Bitmap bmRotate = null;

        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(90);
        bmRotate = Bitmap.createBitmap(bmSrc, 0, 0,
                bmSrc.getWidth(), bmSrc.getHeight(),
                matrix, true);


        bmSrc.recycle();
        return bmRotate;
    }

    /**
     * 保存图片
     *
     * @param bmToSave
     */
    public void saveBitmap(Bitmap bmToSave) {
        //以时间为文件名
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        time = simpleDateFormat.format(new Date());
        File file = new File("/sdcard/" + time + ".jpg");

        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bmToSave.compress(Bitmap.CompressFormat.JPEG,
                    100,
                    bufferedOutputStream);//将图片压缩到流中
            bufferedOutputStream.flush();//输出
            bufferedOutputStream.close();//关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.take_picture_switch)
    public void takePicture(View view){
        //第一个参数按下快门时回调，第二个参数处理原始的照片数据，第三个参数处理jpeg格式照片，一般用于存放照片
        mCamera.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Bitmap bmSrc = BitmapFactory.decodeByteArray(data,
                        0,
                        data.length);
                Bitmap bmRotate = RotateBitmap(bmSrc);//旋转

                saveBitmap(bmRotate);//保存


            }

        });

        switchIv.setVisibility(View.GONE);
        cancelTv.setVisibility(View.GONE);
        surfaceIv.setVisibility(View.GONE);
        againTv.setVisibility(View.VISIBLE);
        okTv.setVisibility(View.VISIBLE);
    }

    /**
     * 返回到上一页
     * @param view
     */
    @OnClick(R.id.take_picture_cancel)
    public void backUp(View view){
        finish();
        this.overridePendingTransition(R.anim.activity_close_exit, R.anim.activity_close_enter);

    }

    /**
     * 拍照帮助
     * @param view
     */
    @OnClick(R.id.take_picture_help_tv)
    public void takePicHelp(View view){
        CustomAlertDialog dialog = new CustomAlertDialog(this);
        dialog.setTitle("拍照帮助");
        dialog.setMessage("  尊敬的用户，您好，按下底部中间区域的圆形按钮可拍摄照片，请物随意拍照。/r/n详情请咨询：0851-87899xx");
    }

    /**
     * 重拍
     * @param view
     */
    @OnClick(R.id.take_picture_again)
    public void againTakePic(View view){
        switchIv.setVisibility(View.VISIBLE);
        cancelTv.setVisibility(View.VISIBLE);
        surfaceIv.setVisibility(View.VISIBLE);
        againTv.setVisibility(View.GONE);
        okTv.setVisibility(View.GONE);

        //重新开启预览
        mCamera.startPreview();
    }
    /**
     * 确定拍照
     * @param view
     */
    @OnClick(R.id.take_picture_ok)
    public void okTakePic(View view){
        Intent i = getIntent();
        String postion = i.getStringExtra("postion");
        i.putExtra("postion",postion);
        i.putExtra("picName",time);
        setResult(RESULT_OK,i);
        this.finish();
    }

}
