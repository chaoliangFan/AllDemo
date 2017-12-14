package com.example.fanxh.wannianli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class GuanYuActivity extends AppCompatActivity {
    private List<Image> imageList=new ArrayList<Image>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guan_yu);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initImages();
        ImageAdapter adapter=new ImageAdapter(GuanYuActivity.this,R.layout.image_item,imageList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {   Image image=imageList.get(position);
                switch (image.getImageId()){
                    case R.drawable.ic_0003:
                        finish();
                        break;
                    case R.drawable.ic_010:
                      Intent intent=new Intent(GuanYuActivity.this,HtmlActivity.class);
//                        intent.setData(Uri.parse("file:///app/build/intermediates/assets/disclaimer.html"));
                       startActivity(intent);
                        break;
                    case R.drawable.ic_008:
                        Intent intent1=new Intent(GuanYuActivity.this,EditActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                }

            }
        });
    }
    private void initImages(){
        Image aA=new Image(R.drawable.ic_0003);
        imageList.add(aA);
        Image a=new Image(R.drawable.ic_004);
        imageList.add(a);
        Image b=new Image(R.drawable.ic_005);
        imageList.add(b);
        Image c=new Image(R.drawable.ic_006);
        imageList.add(c);
        Image d=new Image(R.drawable.ic_007);
        imageList.add(d);
        Image e=new Image(R.drawable.ic_008);
        imageList.add(e);
        Image f=new Image(R.drawable.ic_010);
        imageList.add(f);
        Image g=new Image(R.drawable.ic_009);
        imageList.add(g);
    }
}
