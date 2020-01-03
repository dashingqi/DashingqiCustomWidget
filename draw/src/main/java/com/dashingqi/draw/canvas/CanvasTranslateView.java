package com.dashingqi.draw.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.canvas
 * @ClassName: CanvasTranslateView
 * @Author: DashingQI
 * @CreateDate: 2020-01-02 23:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-02 23:26
 * @UpdateRemark:
 * @Version: 1.0
 *
 * 画布的原状是以左上角为原点，向右是X轴正方向，向下是Y轴的正方向。
 * Canvas是一个很虚幻的概念，相当于一个透明层，每次Canvas画图的时候，都会产生一个透明图层，然后在这个透明图层上画图，画完后覆盖到屏幕上显示。
 */
public class CanvasTranslateView extends View {
    public CanvasTranslateView(Context context) {
        super(context);
    }

    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint green_paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint red_paint = generatePaint(Color.RED, Paint.Style.STROKE, 3);


        RectF rectF = new RectF(0, 0, 400, 200);
        canvas.drawRect(rectF,green_paint);
        canvas.translate(100,100);
        canvas.drawRect(rectF,red_paint);
    }

    private Paint generatePaint(int color,Paint.Style style,int width){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);

        return paint;
    }
}
