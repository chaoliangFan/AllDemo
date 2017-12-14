package com.example.fanxh.datatest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String t = "20:00";
// 解析格式，yyyy表示年，MM(大写M)表示月,dd表示天，HH表示小时24小时制，小写的话是12小时制
// mm，小写，表示分钟，ss表示秒
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//        String t = format.format(new Date());
        try {
// 用parse方法，可能会异常，所以要try-catch
            Date date = format.parse(t);
            Log.e("MainActivity","date--->"+date);
// 获取日期实例
            Calendar calendar = Calendar.getInstance();
// 将日历设置为指定的时间
            calendar.setTime(date);
// 获取年
            int year = calendar.get(Calendar.YEAR);
            Log.e("MainActivity","year--->"+year);
// 这里要注意，月份是从0开始。
            int month = calendar.get(Calendar.MONTH);
            Log.e("MainActivity","month--->"+month);
// 获取天
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            Log.e("MainActivity","day--->"+day);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            Log.e("MainActivity","hour--->"+hour);
            int ss = calendar.get(Calendar.MINUTE);
            Log.e("MainActivity","minute--->"+ss);
 //           int second = calendar.get(Calendar.SECOND);
  //          Log.e("MainActivity","second--->"+second);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
