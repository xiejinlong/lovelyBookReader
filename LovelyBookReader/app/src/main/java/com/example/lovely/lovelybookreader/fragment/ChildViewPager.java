package com.example.lovely.lovelybookreader.fragment;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by lovely on 16/10/20.
 */

public class ChildViewPager extends ViewPager {

    private PointF downP = new PointF();
    private PointF currentP = new PointF();

    public ChildViewPager(Context context) {
        super(context);
    }

    public ChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private void click() {
        Toast.makeText(getContext(),"你进行了单击",Toast.LENGTH_SHORT).show();
    }
}
