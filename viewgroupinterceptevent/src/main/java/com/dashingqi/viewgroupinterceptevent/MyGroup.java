package com.dashingqi.viewgroupinterceptevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * @author Dashingqi
 * @description:
 * @date :2020-02-14 11:36
 */
public class MyGroup extends ViewGroup {
    private float mLastX = 0.0f;
    private float mLastY = 0.0f;

    public MyGroup(Context context) {
        super(context);
    }

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //外部拦截法的处理方式
        /*boolean interceptTouchEvent = false;
        float x = ev.getX();
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                //如果ACTION_DOWN事件被拦截那么之后的ACTION_MOVE和ACTION_UP都会被拦截。交给父容器来处理
                interceptTouchEvent = false;
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                if (x > 0) {
                    interceptTouchEvent = true;

                } else {
                    interceptTouchEvent = false;
                }
            }
            break;
            case MotionEvent.ACTION_UP: {
                interceptTouchEvent = false;

            }
            break;
        }
        mLastX = x;
        mLastY = y;
        return interceptTouchEvent;*/

        //内部拦截处理如下
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            return false;
        } else {
            return true;
        }

    }
}
