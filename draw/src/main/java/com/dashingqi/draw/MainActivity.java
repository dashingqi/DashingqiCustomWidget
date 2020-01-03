package com.dashingqi.draw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.dashingqi.draw.canvas.CanvasClipView;
import com.dashingqi.draw.canvas.CanvasRotateView;
import com.dashingqi.draw.canvas.CanvasSaveAndRestoreView;
import com.dashingqi.draw.canvas.CanvasScaleView;
import com.dashingqi.draw.canvas.CanvasSkewView;
import com.dashingqi.draw.canvas.CanvasTranslateView;
import com.dashingqi.draw.path_text.PathArcView;
import com.dashingqi.draw.path_text.PathCircleView;
import com.dashingqi.draw.path_text.PathOvalView;
import com.dashingqi.draw.path_text.PathRoundRectView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayoutContainer = findViewById(R.id.layout_container);
        // mLayoutContainer.addView(new CircleView(this));
        //mLayoutContainer.addView(new LineView(this));
        //mLayoutContainer.addView(new PointView(this));
        //mLayoutContainer.addView(new RectView(this));
        //mLayoutContainer.addView(new RoundRectView(this));
        //mLayoutContainer.addView(new OvalView(this));
        //mLayoutContainer.addView(new ArcView(this));
        //mLayoutContainer.addView(new PathLineView(this));
        //mLayoutContainer.addView(new PathRectView(this));
        //mLayoutContainer.addView(new PathRoundRectView(this));
        // mLayoutContainer.addView(new PathCircleView(this));
        //mLayoutContainer.addView(new PathOvalView(this));
        //mLayoutContainer.addView(new PathArcView(this));

        //mLayoutContainer.addView(new CanvasTranslateView(this));
        //mLayoutContainer.addView(new CanvasRotateView(this));
        //mLayoutContainer.addView(new CanvasScaleView(this));
        //mLayoutContainer.addView(new CanvasSkewView(this));
        //mLayoutContainer.addView(new CanvasClipView(this));

        mLayoutContainer.addView(new CanvasSaveAndRestoreView(this));

    }
}
