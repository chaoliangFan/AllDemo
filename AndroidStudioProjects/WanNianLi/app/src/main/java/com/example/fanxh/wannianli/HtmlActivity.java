package com.example.fanxh.wannianli;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class HtmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

//        ActionBar actionBar=getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }

        WebView webview=(WebView)findViewById(R.id.web);
        webview.loadUrl("file:///android_asset/disclaimer.html");
    }
}
