package com.example.fanxh.url_imageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    public static final int SHOW_RESPONSE = 0;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_RESPONSE:
//                    InputStream inputStream = (InputStream) msg.obj;
//                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Bitmap bitmap = (Bitmap) msg.obj;
                    mImageView.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
//        loadImage();
        getImageViewInputStream();

    }
        public void getImageViewInputStream(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream inputStream = null;
                    try {
            URL url = new URL("http://img1.2345.com/toolsimg/calendar/images/upload/59cb35750c9eb.png");                    //服务器地址
            if (url != null) {
                //打开连接
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setConnectTimeout(1000);//设置网络连接超时的时间为3秒
                httpURLConnection.setRequestMethod("GET");        //设置请求方法为GET
                httpURLConnection.setDoInput(true);                //打开输入流
                int responseCode = httpURLConnection.getResponseCode();    // 获取服务器响应值
                if (responseCode == HttpURLConnection.HTTP_OK) {        //正常连接
                    inputStream = httpURLConnection.getInputStream();        //获取输入流
                }
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Message message = new Message();
                message.what = SHOW_RESPONSE;
                message.obj = bitmap;
                handler.sendMessage(message);
            }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }

}
