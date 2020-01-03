package com.dashingqi.draw.path_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.path_text
 * @ClassName: PathOvalView
 * @Author: DashingQI
 * @CreateDate: 2019-12-26 00:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-26 00:26
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathOvalView extends View {

    private Paint mPaint;

    public PathOvalView(Context context) {
        this(context, null);
    }

    public PathOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(50, 50, 300, 140);
        path.addOval(rectF, Path.Direction.CW);
        canvas.drawPath(path, mPaint);
    }
}
