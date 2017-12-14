package com.example.fanxh.jsontest;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView jsonText;
    private final static String fileName = "data1.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        jsonText = (TextView) findViewById(R.id.json_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) getJson(fileName,MainActivity.this);
                parseJSONWithGSON(str);

            }
        });
    }
    private void parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
       // ArrayList<Data> dataList =  new ArrayList<Data>();
        List<Data> dataList = gson.fromJson(jsonData,new TypeToken<List<Data>>(){}.getType());
        for (Data data1 : dataList){
            Log.d("MainActivity","icon is "+ data1.getIcon());
        }
    }
    public static String getJson(String fileName,Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
