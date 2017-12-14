package com.example.fanxh.java;

/**
 * Created by fanxh on 2017/10/10.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
