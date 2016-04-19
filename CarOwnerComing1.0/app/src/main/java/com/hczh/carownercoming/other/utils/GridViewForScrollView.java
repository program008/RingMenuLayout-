package com.hczh.carownercoming.other.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by LiuTao008
 * on 2016/2/25.
 */
public class GridViewForScrollView extends GridView {
    public GridViewForScrollView(Context context) {
        super(context);
    }
    public GridViewForScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public GridViewForScrollView(Context context, AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
    }
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
