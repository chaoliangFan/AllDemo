package com.example.fanxh.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private IntentFilter intentFilter;
//    private NetworkChangeReceiver networkChangeReceiver;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.fanxh.broadcasttest.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });


//        intentFilter=new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver=new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);
    }
}
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//    }
//
//    class NetworkChangeReceiver extends BroadcastReceiver{
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo=connectionManager.getActiveNetworkInfo();
//            if (networkInfo!=null&&networkInfo.isAvailable()){
//                Toast.makeText(context,"网络可用",Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
