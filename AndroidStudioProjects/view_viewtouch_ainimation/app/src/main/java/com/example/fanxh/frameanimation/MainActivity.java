package com.example.fanxh.frameanimation;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button view;
    private Button view_touch;
    private Button animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (Button)findViewById(R.id .view);
        view.setOnClickListener(this);
        view_touch = (Button)findViewById(R.id.view_touch);
        view_touch.setOnClickListener(this);
        animation = (Button) findViewById(R.id.animation);
        animation.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view:
                Intent intent = new Intent(this,MView.class);
                startActivity(intent);
                break;
            case R.id.view_touch:
            case R.id.animation:
                Intent intent_animation = new Intent(MainActivity.this, FrameAnimation.class);
                startActivity(intent_animation);
            default:
                break;
        }

    }
}
