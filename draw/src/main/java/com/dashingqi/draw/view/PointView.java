package com.dashingqi.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.view
 * @ClassName: PointView
 * @Author: DashingQI
 * @CreateDate: 2019-12-23 23:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-23 23:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PointView extends View {

    private Paint mPaint;
    public PointView(Context context) {
        this(context,null);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        //设置画笔的颜色
        mPaint.setColor(Color.RED);
        //设置画笔的填充样式
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔的抗锯齿
        mPaint.setAntiAlias(true);
        //设置阴影
        mPaint.setShadowLayer(20,20,20,Color.BLUE);
        mPaint.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画一个点
        //canvas.drawPoint(100,100,mPaint);
        //画多个点
        float [] pts = {10,10,100,100,200,200,400,400};

        //两个数值为一个点，忽略前面两个点，画出后面4个点
        canvas.drawPoints(pts,2,4,mPaint);

    }
}
