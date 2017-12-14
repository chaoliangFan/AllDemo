package com.example.fanxh.drawview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MVIew mvIew = new MVIew(getApplicationContext());
     //   ViewTwo viewTwo = new ViewTwo(getApplicationContext());
        RelativeLayout main_layout = (RelativeLayout) findViewById(R.id.main_layout);
        main_layout.addView(mvIew);
       // main_layout.addView(viewTwo);
    }
}
