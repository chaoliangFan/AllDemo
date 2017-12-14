package com.example.fanxh.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by fanxh on 2017/9/26.
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_SHORT).show();
    }
}
