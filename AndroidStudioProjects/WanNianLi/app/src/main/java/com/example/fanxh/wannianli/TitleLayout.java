package com.example.fanxh.wannianli;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by fanxh on 2017/9/25.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button=(Button)findViewById(R.id.back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ( (Activity)getContext()).finish();
            }
        });
    }
}
