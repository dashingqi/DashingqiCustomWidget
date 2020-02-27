package com.dashingqi.myflowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyFlowLayoutView extends ViewGroup {
    /**
     * 用于保存一行放置了多少View
     */
    private List<View> mLineViews = new ArrayList<>();

    /**
     * 用于保存每一行 从而得知有展示了多少行
     */
    private List<List<View>> mAllLineViews = new ArrayList<>();

    /**
     * 用于保存每一行计算出来的高度值
     */
    private List<Integer> mLineHeights = new ArrayList<>();

    /**
     * 用于保存每一行计算出来的宽度值
     */
    private List<Integer> mLineWidths = new ArrayList<>();

    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;
    private int mGravity = LEFT;


    public MyFlowLayoutView(Context context) {
        this(context, null);
    }

    public MyFlowLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFlowLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int lineWidth = 0, lineHeight = 0, realWidth = 0, realHeight = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        //测量子View，从而得出一个临时测量过程中ViewGroup的宽和高
        //在保存ViewGroup的宽和高的时候需要看 MeasureMode的值
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE)
                continue;
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);

            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

            if (lineWidth + childWidth + lp.rightMargin + lp.leftMargin > widthSize - getPaddingLeft() - getPaddingRight()) {
                realWidth = Math.max(realWidth, lineWidth);
                realHeight += lineHeight;
                lineWidth = childWidth;
                lineHeight = childHeight;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == childCount - 1) {
                realWidth = Math.max(realWidth, lineWidth);
                realHeight += lineHeight;
            }
        }

        //保存ViewGroup测量过后的宽和高
        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize : realWidth,
                heightMode == MeasureSpec.EXACTLY ? heightSize : realHeight
        );
    }

    /**
     * 1. 需要知道每一行能放置多少个子View
     * 2. 需要知道展示了多少行
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int lineHeight = 0, lineWidth = 0;
        int childCount = getChildCount();
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE)
                continue;
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
            if (lineWidth + childWidth + lp.leftMargin + lp.height > width - getPaddingLeft() - getPaddingLeft()) {
                mLineHeights.add(lineHeight);
                mLineWidths.add(lineWidth);
                mAllLineViews.add(mLineViews);

                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
                lineWidth = 0;

                mLineViews = new ArrayList<>();
            }
            lineWidth += childWidth;
            lineHeight = Math.max(lineHeight, childHeight);
            mLineViews.add(childView);
        }

        //处理最后一行的时候，保存一下数据
        mLineHeights.add(lineHeight);
        mLineWidths.add(lineWidth);
        mAllLineViews.add(mLineViews);

        int left = getPaddingLeft();
        int top = getPaddingTop();

        int lineCount = mAllLineViews.size();

        for (int i = 0; i < lineCount; i++) {
            //获取每一行保存测量好的View的集合
            mLineViews = mAllLineViews.get(i);
            //当前行的高度
            lineHeight = mLineHeights.get(i);
            //当前行的宽度
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
                }
            }
            for (int j = 0; j < mLineViews.size(); j++) {
                View childView = mLineViews.get(j);
                if (childView.getVisibility() == View.GONE) continue;
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
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
