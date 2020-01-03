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
 * @Package: com.dashingqi.draw.line_text
 * @ClassName: LineView
 * @Author: DashingQI
 * @CreateDate: 2019-12-25 23:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-12-25 23:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PathLineView extends View {

    private Paint mPaint;

    public PathLineView(Context context) {
        this(context,null);
    }

    public PathLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        mPaint = new Paint();
        //设置画笔的颜色
        mPaint.setColor(Color.RED);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔的宽度
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        //设置起点位置
        path.moveTo(10,10);
        //第一条直线的终点，也是第二条直线的起点
        path.lineTo(10,100);
        //第二条直线的终点
        path.lineTo(300,100);
        path.lineTo(500,100);

        //形成一个闭合的路径
        path.close();

        canvas.drawPath(path,mPaint);
    }
}
