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
 * @ClassName: CanvasScaleView
 * @Author: DashingQI
 * @CreateDate: 2020-01-03 00:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-03 00:07
 * @UpdateRemark:
 * @Version: 1.0
 *
 * 这里有 X和Y轴的密度的改变，显示到图形上就会正好相同，比如X轴缩小，那么显示的图形也会缩小，Y同理
 */
public class CanvasScaleView extends View {
    public CanvasScaleView(Context context) {
        this(context,null);
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint_green = ViewUtils.generatePaint(Color.GREEN, Paint.Style.STROKE, 5);
        Paint paint_red = ViewUtils.generatePaint(Color.RED, Paint.Style.STROKE, 5);

        RectF rectF = new RectF(10, 10, 200, 100);
        canvas.drawRect(rectF,paint_green);
        //X轴的密度缩小成 0.6 Y轴不变
        canvas.scale(0.6f,1);
        canvas.drawRect(rectF,paint_red);
    }
}
