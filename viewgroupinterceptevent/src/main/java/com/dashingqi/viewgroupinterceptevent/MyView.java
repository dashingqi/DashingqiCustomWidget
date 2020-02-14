package com.dashingqi.viewgroupinterceptevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Dashingqi
 * @description:
 * @date :2020-02-14 15:02
 */
public class MyView extends View {
    private float mLastX = 0.0f;
    private float mLastY = 0.0f;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                getParent().requestDisallowInterceptTouchEvent(true);

            }
            break;
            case MotionEvent.ACTION_MOVE: {
                float delayX = x - mLastY;
                float delayY = y - mLastY;

                //父容器需要此类点击事件
                if (delayX > 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            break;
            case MotionEvent.ACTION_UP: {

            }
            break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }
}
