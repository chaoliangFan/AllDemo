package com.example.fanxh.listviewtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.fanxh.listviewtest.R.layout.fruit_item;

public class MainActivity extends Activity {

    //private String[] data={"Apple","Banana","Orange","Watermelon"};
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        @SuppressLint("ResourceType")
        FruitAdapter adapter=new FruitAdapter(MainActivity.this, R.layout.fruit_item,fruitList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
//        ListView listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);


    }

    private void initFruits() {
        for (int i=0;i<4;i++) {
            Fruit apple = new Fruit("Apple", R.drawable.ic_01);
            Fruit banana = new Fruit("Banana", R.drawable.ic_02);
            Fruit orange = new Fruit("Orange", R.drawable.ic_o3);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.ic_04);
            fruitList.add(apple);
            fruitList.add(banana);
            fruitList.add(orange);
            fruitList.add(watermelon);
        }

    }
}
