package com.example.administrator.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class FourActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FourActivity","Task id is"+getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_four);
        Button button4=(Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourActivity.this,FiveActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("FourActivity","onDestroy");
//
//    }
}
