package com.example.fanxh.servicetest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.Log;

/**
 * Created by fanxh on 2017/10/6.
 */

public class MyService extends Service {

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService","startDownload executed");
        }
        public int getProgress() {
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
    private DownloadBinder mBinder = new DownloadBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService","onCreate executed");
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("this is title")
                .setContentText("this is text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker("1111111111111")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_round))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}
