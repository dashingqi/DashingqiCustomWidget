package com.dashingqi.draw.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.canvas
 * @ClassName: CanvasSaveAndRestoreView
 * @Author: DashingQI
 * @CreateDate: 2020-01-03 00:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-03 00:22
 * @UpdateRemark:
 * @Version: 1.0
 *
 * save(): 每次调用save函数的时候，都会把当前的画布状态进行保存，然后放入特定的栈中
 *
 * restore():每次调用restore函数，就会把栈中最顶层的画布状态取出来，按照这个状态恢复当前的画布，并在这个画布上做画。
 */
public class CanvasSaveAndRestoreView extends View {
    public CanvasSaveAndRestoreView(Context context) {
        this(context,null);
    }

    public CanvasSaveAndRestoreView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasSaveAndRestoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        //保存画布
        canvas.save();

        canvas.clipRect(new Rect(100,100,800,800));

        canvas.drawColor(Color.YELLOW);

        //恢复画布
        canvas.restore();

        canvas.drawColor(Color.BLUE);

    }
}
