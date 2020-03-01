package com.dashingqi.myflowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyFlowLayoutViewTwo extends ViewGroup {

    private List<View> mLineViews = new ArrayList<>();
    private List<List<View>> mAllLineViews = new ArrayList<>();

    private List<Integer> mLineWidths = new ArrayList<>();
    private List<Integer> mLineHeights = new ArrayList<>();

    private int mGravity = -1;

    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;

    public MyFlowLayoutViewTwo(Context context) {
        this(context, null);
    }

    public MyFlowLayoutViewTwo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFlowLayoutViewTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int lineWidth = 0, lineHeight = 0, width = 0, height = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE) continue;

            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

            if (childWidth + lineWidth + lp.rightMargin + lp.leftMargin > widthSize - getPaddingLeft() - getPaddingRight()) {
                height += lineHeight;
                width = Math.max(width, lineWidth);
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == childCount - 1) {
                height += lineHeight;
                width = Math.max(width, lineWidth);
            }
        }
        //测量ViewGroup的height和width
        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize : width,
                heightMode == MeasureSpec.EXACTLY ? heightSize : height
        );


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int lineWidth = 0, lineHeight = 0;
        int childCount = getChildCount();
        int height = getHeight();
        int width = getWidth();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE)
                continue;
            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
            int childWidth = childView.getMeasuredWidth();
            int childHeight = getMeasuredHeight();
            if (childWidth + lp.leftMargin + lp.rightMargin + lineWidth > width - getPaddingLeft() - getPaddingRight()) {
                //这一行已经显示不上这个View了
                mLineHeights.add(lineHeight);
                mLineWidths.add(lineWidth);
                mAllLineViews.add(mLineViews);

                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;

                mLineViews = new ArrayList<>();
            }

            lineHeight = Math.max(lineHeight, childHeight);
            lineWidth += childWidth;
            mLineViews.add(childView);
        }

        mLineHeights.add(lineHeight);
        mLineWidths.add(lineWidth);
        mAllLineViews.add(mLineViews);


        int left = getPaddingLeft();
        int top = getPaddingTop();


        for (int i = 0; i < mAllLineViews.size(); i++) {
            //获取每一行View的集合
            mLineViews = mAllLineViews.get(i);
            lineWidth = mLineWidths.get(i);
            lineHeight = mLineWidths.get(i);

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
                }
                break;
            }

            for (int j = 0; j < mLineViews.size(); i++) {
                View childView = mLineViews.get(j);
                if (childView.getVisibility() == View.GONE)
                    continue;
                MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
                int childWidth = childView.getMeasuredWidth();
                int childHeight = childView.getMeasuredHeight();

                int childLeft = left + lp.leftMargin;
                int childTop = top + lp.topMargin;
                int childRight = childLeft + childWidth;
                int childBottom = childTop + childHeight;

                childView.layout(childLeft, childTop, childRight, childBottom);

                left += childWidth + lp.leftMargin + lp.rightMargin;
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
