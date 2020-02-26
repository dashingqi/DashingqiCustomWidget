package com.dashingqi.myflowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyFlowLayout extends ViewGroup {

    private List<Integer> mLineWidths = new ArrayList<>();
    private List<Integer> mLineHeights = new ArrayList<>();

    //用于保存每一行的View
    private List<View> mLineViews = new ArrayList<>();

    //用于保存每一行的List
    private List<List<View>> mAllLineViews = new ArrayList<>();


    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;
    private int mGravity = 1;

    public MyFlowLayout(Context context) {
        this(context, null);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0, height = 0, lineHeight = 0, lineWidth = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
            if (lineWidth + childWidth + lp.leftMargin + lp.rightMargin > widthSize - getPaddingLeft() - getPaddingRight()) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
                lineWidth = childWidth;
                lineHeight = childHeight;

            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == childCount - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }

        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize : width,
                heightMode == MeasureSpec.EXACTLY ? heightSize : height);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int lineWidth = 0, lineHeight = 0;
        int left = getPaddingLeft();
        int right = getPaddingRight();
        int childCount = getChildCount();

        int height = getHeight();
        int width = getWidth();
        int top = getTop();

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

            if (lineWidth + childWidth + lp.leftMargin + lp.rightMargin > width - getPaddingLeft() - getPaddingRight()) {
                //满一行了，不能再次添加了
                mLineHeights.add(lineHeight);
                mLineWidths.add(lineWidth);
                mAllLineViews.add(mLineViews);

                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
                mLineViews = new ArrayList<>();
            }

            lineWidth += childWidth + lp.rightMargin + lp.leftMargin;
            lineHeight = Math.max(lineHeight, childHeight);
            mLineViews.add(childView);
        }
        mLineHeights.add(lineHeight);
        mLineWidths.add(lineWidth);
        mAllLineViews.add(mLineViews);


        for (int i = 0; i < mAllLineViews.size(); i++) {
            mLineViews = mAllLineViews.get(i);
            lineHeight = mLineHeights.get(i);
            lineWidth = mLineWidths.get(i);
            switch (mGravity) {
                case LEFT: {
                    left = getPaddingLeft();
                }
                break;
                case CENTER: {
                    left = (width - lineWidth) / 2 + getPaddingLeft();
                }
                break;
                case RIGHT: {
                    left = width - (lineWidth + getPaddingLeft()) + getPaddingRight();
                    //Collections.reverse(mLineViews);
                }
                break;
            }

            for (int j = 0; j < mLineViews.size(); j++) {
                View childView = mLineViews.get(j);
                MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

                int childLeft = left + lp.leftMargin;
                int childTop = top + lp.topMargin;
                int childRight = childLeft + childView.getMeasuredWidth();
                int childBottom = childTop + childView.getMeasuredHeight();

                childView.layout(childLeft, childTop, childRight, childBottom);
                left += childView.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }
            top += lineHeight;

        }


    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
}
