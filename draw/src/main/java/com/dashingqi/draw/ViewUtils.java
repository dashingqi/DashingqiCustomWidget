package com.dashingqi.draw;

import android.graphics.Paint;

/**
 * @ProjectName: DashingqiCustomWidget
 * @Package: com.dashingqi.draw
 * @ClassName: ViewUtils
 * @Author: DashingQI
 * @CreateDate: 2020-01-03 00:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020-01-03 00:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ViewUtils {


    public static Paint generatePaint(int color, Paint.Style style, int width){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);

        return paint;
    }
}
