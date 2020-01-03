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
 * @Package: com.dashingqi.draw
 * @ClassName: LineView
 * @Author: DashingQI
 * @CreateDate: 2019-12-23 23:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-23 23:36
 * @UpdateRemark:
 * @Version: 1.0
 */
public class LineView extends View {

    private Paint mPaint;

    public LineView(Context context) {
        this(context,null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画一条直线
        canvas.drawLine(50,60,120,240,mPaint);
        //画多条直线
        float [] pts = {20,40,120,140,160,180,200,220};
        canvas.drawLines(pts,mPaint);
    }
}
