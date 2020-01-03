package com.dashingqi.draw.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.dashingqi.draw.ViewUtils;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.canvas
 * @ClassName: CanvasRotateView
 * @Author: DashingQI
 * @CreateDate: 2020-01-02 23:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-02 23:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CanvasRotateView extends View {
    public CanvasRotateView(Context context) {
        this(context,null);
    }

    public CanvasRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint_green = ViewUtils.generatePaint(Color.GREEN, Paint.Style.FILL, 5);
        Paint paint_red = ViewUtils.generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect = new Rect(300, 10, 500, 100);
        canvas.drawRect(rect,paint_red);
        //顺时针旋转90度
        canvas.rotate(45);

        canvas.drawRect(rect,paint_green);
    }


}
