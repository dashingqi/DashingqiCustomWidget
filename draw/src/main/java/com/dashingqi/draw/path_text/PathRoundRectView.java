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
 * @ClassName: PathRoundRect
 * @Author: DashingQI
 * @CreateDate: 2019-12-26 00:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-26 00:08
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathRoundRectView extends View {

    private Paint mPaint;

    public PathRoundRectView(Context context) {
        this(context,null);
    }

    public PathRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(50, 50, 240, 200);
        path.addRoundRect(rectF,10,10,Path.Direction.CW);
        canvas.drawPath(path,mPaint);
    }
}
