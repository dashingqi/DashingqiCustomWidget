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
 * @ClassName: PathArcView
 * @Author: DashingQI
 * @CreateDate: 2019-12-26 00:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-26 00:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathArcView extends View {

    private Paint mPaint;

    public PathArcView(Context context) {
        this(context, null);
    }

    public PathArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(50, 50, 240, 200);
        path.addArc(rectF, 0, 360);

        canvas.drawPath(path, mPaint);
    }
}
