package com.dashingqi.draw.path_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.path_text
 * @ClassName: PathRectView
 * @Author: DashingQI
 * @CreateDate: 2019-12-25 23:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-25 23:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathRectView extends View {

    private Paint mPaint;

    public PathRectView(Context context) {
        this(context, null);
    }

    public PathRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画一个逆时针方向的矩形
        Path CCWRectpath = new Path();
        RectF rect = new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rect, Path.Direction.CCW);

        //顺时针方向画的矩形
        Path CWRectPath = new Path();
        RectF rectF2 = new RectF(290, 50, 480, 200);
        CWRectPath.addRect(rectF2, Path.Direction.CW);

        //画出这两个路径
        canvas.drawPath(CCWRectpath, mPaint);
        canvas.drawPath(CWRectPath, mPaint);

        String text = "今天是星期几呢？？？？？？";
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(28);
        mPaint.setStrokeWidth(4);
        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, mPaint);
        canvas.drawTextOnPath(text, CWRectPath, 0, 18, mPaint);
    }
}
