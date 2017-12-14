package com.example.administrator.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity","Task id is"+getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);

        Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThirdActivity.this,FourActivity.class);
                startActivity(intent);
            }
        });

//        Button button3=(Button)findViewById(R.id.button_3);
//        button3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
//                startActivity(intent);
//            }
//        });

//        Button button3=(Button)findViewById(R.id.button_3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//            }
//        });

    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("ThirdActivity","onRestart");
//    }
}
