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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getChildCount() <= 1) {
            return super.onTouchEvent(event);
        }
        currentP.x = event.getX();
        currentP.y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            downP.x = event.getX();
            downP.y = event.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.i("XJL","===>"+getCurrentItem());
            Log.i("XJL","====>"+getChildCount());
            if (getCurrentItem() != 0 || getCurrentItem() != (getChildCount() - 1)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                Log.i("XJL","====>监测到是首页或者末页");
                getParent().requestDisallowInterceptTouchEvent(false);
                return true;
            }

        }
        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
            getParent().requestDisallowInterceptTouchEvent(false);
            if (downP.x == currentP.x && downP.y == currentP.y) {
                click();
                return true;
            }
        }
        super.onTouchEvent(event);
        return true;
    }

    private void click() {
        Toast.makeText(getContext(),"你进行了单击",Toast.LENGTH_SHORT).show();
    }
}
