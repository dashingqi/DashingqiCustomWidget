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
 * @ClassName: CircleView
 * @Author: DashingQI
 * @CreateDate: 2019-12-23 23:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-23 23:26
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CircleView extends View {

    private Paint mPaint;

    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //设置填充样式 Style.FILL  Style.STROKE  Style.FILL_AND_STROKE
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔的宽度
        mPaint.setStrokeWidth(5);
        //设置阴影
        mPaint.setShadowLayer(10,15,15,Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布的背景色
        canvas.drawRGB(255,255,255);
        //画圆
        canvas.drawCircle(200,200,120,mPaint);
    }
}
