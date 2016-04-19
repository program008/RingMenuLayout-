package com.hczh.carownercoming.home.personalcentre.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hczh.carownercoming.R;
import com.hczh.carownercoming.other.ui.BaseFragment;
import com.hczh.carownercoming.other.utils.LogUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * 个人中心
 * Created by LiuTao008
 * on 2016/4/11.
 */
public class PersonalCentreFragment extends BaseFragment implements View.OnClickListener {
    @ViewInject(R.id.personal_centre_add_car_iv)
    private ImageView addCarIv;//添加车辆
    @ViewInject(R.id.personal_centre_change)
    private TextView changeNumberTv;//更改号码
    @Override
    protected int getLayout() {
        return R.layout.fragment_personalcentre;
    }

    @Override
    protected void initViews() {
        ViewUtils.inject(this, root);

    }

    @Override
    protected void initEvents() {
        addCarIv.setOnClickListener(this);
        changeNumberTv.setOnClickListener(this);

    }
    @Override
    protected void initData() {

    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        LogUtil.d("hczh",view.getId()+"");
        Intent intent=null;

        switch (view.getId()){
           case R.id.personal_centre_add_car_iv:
               intent = new Intent(getActivity(),AddCarActivity.class);
               startActivity(intent);
               break;
           case R.id.personal_centre_change:
               LogUtil.d("hzch","更改");
               intent = new Intent(getActivity(),ChangeNubmerActivity.class);
               startActivity(intent);
           default:
               break;

       }
        getActivity().overridePendingTransition(R.anim.activity_open_enter, R.anim.activity_open_exit);
    }
}
