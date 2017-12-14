package com.example.fanxh.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new Notification(R.drawable.ic_launcher,"this is ticker text",System.currentTimeMillis());
//                notification.setLatesEventInfo(context,"this is content title","this is content text",null);
                Intent intent = new Intent(this,Main2Activity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
               Notification notification = new NotificationCompat.Builder(this)
                       .setContentTitle("This is content title")
                       .setStyle(new NotificationCompat.BigTextStyle().bigText("qqqqqqqqqq"))
                       .setContentText("this is content text")
                       .setWhen(System.currentTimeMillis())
                       .setSmallIcon(R.drawable.ic_launcher)
                       .setTicker("ticker_ticker")
                       //设置通知是手机震动
                       .setVibrate(new long[] {0,1000})
                       //设置通知是LED灯的闪烁情况
                       .setLights(Color.RED,1000,1000)
//                       使用默认设置，根据当前手机的环境来决定播放什么铃声，以及如何震动
//                       .setDefaults(NotificationCompat.DEFAULT_ALL)
                       .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_round))
                       .setContentIntent(pi)
                       .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }

    }
}
