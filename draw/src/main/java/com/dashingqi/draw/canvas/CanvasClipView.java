package com.dashingqi.draw.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.dashingqi.draw.ViewUtils;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw.canvas
 * @ClassName: CanvasClipView
 * @Author: DashingQI
 * @CreateDate: 2020-01-03 00:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-03 00:18
 * @UpdateRemark:
 * @Version: 1.0
 *
 * 画布的裁剪
 */
public class CanvasClipView extends View {
    public CanvasClipView(Context context) {
        this(context,null);
    }

    public CanvasClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //ViewUtils.generatePaint(Color.GREEN,)
        canvas.drawColor(Color.RED);
        canvas.clipRect(new RectF(100,100,200,200));
        canvas.drawColor(Color.YELLOW);
    }
}
