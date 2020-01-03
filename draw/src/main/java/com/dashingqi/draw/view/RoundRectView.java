package com.dashingqi.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.view
 * @ClassName: RoundRectView
 * @Author: DashingQI
 * @CreateDate: 2019-12-24 00:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-24 00:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RoundRectView extends View {
    private Paint mPaint;
    public RoundRectView(Context context) {
        super(context);
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

        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawRoundRect(rectF,30,10,mPaint);
    }
}
