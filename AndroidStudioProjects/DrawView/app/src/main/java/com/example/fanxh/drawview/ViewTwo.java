package com.example.fanxh.drawview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by fanxh on 2017/10/19.
 */

public class ViewTwo extends View {
    private String text = "自定义viewTwo";
    private float textSize = 48;
    private int textColor = 0xFFFFFFFF;
    private Paint mPaint;
    private Rect mRect;
    private static final String TAG = "ViewTwo";

    public ViewTwo(Context context) {
        super(context);
    }

    public ViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewTwo(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.ViewTwo,defStyleAttr,0);
        textSize = typedArray.getDimension(R.styleable.ViewTwo_textSize,48);
        textColor = typedArray.getColor(R.styleable.ViewTwo_textColor,0xFFFFFFFF);
 //       text = typedArray.getText()
        typedArray.recycle();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createCode();
                Log.d(TAG,"setOnClickListener:"+text);
       //         Toast.makeText(context,"setOnClickListener:")
                postInvalidate();
            }
        });
        mPaint = new Paint();
        //取消锯齿
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        mRect = new Rect();
        //将text的边框赋值给mrect
        mPaint.getTextBounds(text,0,text.length(),mRect);

    }
    private void createCode(){
        text ="";
        for (int i = 0;i<4;i++){
            text +=(int)(Math.random()*10-1)+" ";
        }

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      //  canvas.drawText(text, getMeasuredWidth() / 2 , getMeasuredHeight() / 2 , mPaint);//加6.6是因为有测量误差
     //   canvas.drawText(text, (getMeasuredWidth() / 2) - (mRect.width() / 2) - 6.6f, (getMeasuredHeight() / 2) + (mRect.height() / 2), mPaint);//加6.6是因为有测量误差

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST){
            widthSize = 50;
        }else if (widthMode == MeasureSpec.EXACTLY){
            widthSize = 300;
        }
        if (heightMode == MeasureSpec.AT_MOST){
            heightSize = 50;
        }else if (heightMode ==MeasureSpec.EXACTLY){
            heightSize = 300;
        }
        setMeasuredDimension(widthSize,heightSize);
    }
}
