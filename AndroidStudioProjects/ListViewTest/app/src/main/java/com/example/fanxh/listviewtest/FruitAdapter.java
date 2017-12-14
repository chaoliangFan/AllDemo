package com.example.fanxh.listviewtest;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by fanxh on 2017/9/22.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    @SuppressWarnings("ResourceType")
    public FruitAdapter( MainActivity context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit=getItem(position);//获取当前项的Fruit实例

        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitName=(TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}
