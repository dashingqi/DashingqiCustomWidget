package com.dashingqi.draw.path_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.path_text
 * @ClassName: PathCircleView
 * @Author: DashingQI
 * @CreateDate: 2019-12-26 00:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-26 00:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathCircleView extends View {

    private Paint mPaint;

    public PathCircleView(Context context) {
        this(context, null);
    }

    public PathCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CW);
        canvas.drawPath(path, mPaint);
    }
}
