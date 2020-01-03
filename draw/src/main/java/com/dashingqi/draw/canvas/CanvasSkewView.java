package com.dashingqi.draw.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.dashingqi.draw.ViewUtils;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.canvas
 * @ClassName: CanvasSkewView
 * @Author: DashingQI
 * @CreateDate: 2020-01-03 00:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-03 00:14
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CanvasSkewView extends View {
    public CanvasSkewView(Context context) {
        this(context,null);
    }

    public CanvasSkewView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint_green = ViewUtils.generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red = ViewUtils.generatePaint(Color.RED, Paint.Style.STROKE, 5);

        RectF rectF = new RectF(80, 80, 180, 360);
        canvas.drawRect(rectF,paint_green);

        canvas.skew(1.732f,0);
        canvas.drawRect(rectF,paint_red);
    }
}
