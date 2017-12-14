package com.example.fanxh.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fanxh on 2017/10/19.
 */

public class MVIew extends View {
    public MVIew(Context context) {
        super(context);
    }

//    public MVIew(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        float radius = 200;
        float cx = 300;
        float cy = 300;
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);                       //设置画笔为空心
        paint.setStrokeWidth((float) 50.0);             //设置线宽
        canvas.drawCircle(cx, cy, radius, paint);

        float radius1 = 170;
        float cx1 = 300;
        float cy1 = 300;
        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        canvas.drawCircle(cx, cy, radius1, paint1);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width_size = 1000;
        int height_size = 1000;
        int HEIGHT_MODE = MeasureSpec.getMode(heightMeasureSpec);
        int HEIGHT_SIZE = MeasureSpec.getSize(heightMeasureSpec);
        int Width_Mode = MeasureSpec.getMode(widthMeasureSpec);
        int Width_size = MeasureSpec.getSize(widthMeasureSpec);
        if (HEIGHT_MODE == MeasureSpec.EXACTLY){
            height_size = HEIGHT_SIZE;
        }else if (HEIGHT_MODE == MeasureSpec.AT_MOST){
            height_size = Math.min(HEIGHT_SIZE,height_size);
        }
        if (Width_Mode == MeasureSpec.EXACTLY){
            width_size =Width_size;
        }else if (Width_Mode == MeasureSpec.AT_MOST){
            width_size = Math.min(Width_size,width_size);
        }
        setMeasuredDimension(width_size,height_size);
    }
}
