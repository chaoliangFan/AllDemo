package com.example.fanxh.wannianli;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by fanxh on 2017/9/25.
 */

public class ImageAdapter extends ArrayAdapter<Image> {
    private int resourceId;
    public ImageAdapter(Context context, int textViewResourceId, List<Image> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Image image=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView guanyuImage=(ImageView) view.findViewById(R.id.image_view);
        guanyuImage.setImageResource(image.getImageId());
        return view;
    }
}
