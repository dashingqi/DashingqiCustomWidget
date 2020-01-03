package com.dashingqi.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.view
 * @ClassName: RectView
 * @Author: DashingQI
 * @CreateDate: 2019-12-23 23:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-23 23:59
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RectView extends View {

    private Paint mPaint;
    public RectView(Context context) {
        this(context,null);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        //直接构造
        canvas.drawRect(10,10,50,50,mPaint);
        //使用ReactF
        RectF rectF = new RectF(60, 60, 260, 260);
        canvas.drawRect(rectF,mPaint);
        //使用Rect构造
        Rect rect = new Rect(100, 150, 200, 260);
        canvas.drawRect(rect,mPaint);
    }
}
