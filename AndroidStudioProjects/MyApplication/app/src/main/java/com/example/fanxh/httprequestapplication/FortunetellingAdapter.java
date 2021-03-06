package com.example.fanxh.httprequestapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by fanxh on 2017/10/12.
 */

public class FortunetellingAdapter extends RecyclerView.Adapter <FortunetellingAdapter.ViewHolder>{
    private List<FortunetellingBean> mFortunetellingBeanList;


    private RecyclerView mRecyclerView;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView iconUrl;
        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.fortunetelling_title);
            iconUrl = (ImageView) view.findViewById(R.id.fortunetelling_photo);
        }
    }



    /**
     * LruCache 缓存图片
     */
    private LruCache<String, BitmapDrawable> mMemoryCache;


    public FortunetellingAdapter(List<FortunetellingBean> fortunetellingBeanList){
        mFortunetellingBeanList = fortunetellingBeanList;



        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, BitmapDrawable>(cacheSize) {
            @Override
            protected int sizeOf(String key, BitmapDrawable drawable) {
                return drawable.getBitmap().getByteCount();
            }
        };
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mRecyclerView == null){
            mRecyclerView = (RecyclerView) parent;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fortunetelling_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    FortunetellingBean fortunetellingBean = mFortunetellingBeanList.get(position);
//        holder.iconUrl.setImageBitmap(getImageViewInputStream(fortunetellingBean.getIconUrl()));
        holder.iconUrl.setTag(fortunetellingBean.getIconUrl());
        BitmapDrawable drawable = getBitmapFromMemoryCache(fortunetellingBean.getIconUrl());
        if (drawable != null) {
            holder.iconUrl.setImageDrawable(drawable);
        } else {
            BitmapWorkerTask task = new BitmapWorkerTask();
            task.execute(fortunetellingBean.getIconUrl());
        }


        holder.name.setText(fortunetellingBean.getName());
    }

    @Override
    public int getItemCount() {
        return mFortunetellingBeanList.size();
    }





    /**
     * 将一张图片存储到LruCache中
     */
    public void addBitmapToMemoryCache(String key, BitmapDrawable drawable) {
        if (getBitmapFromMemoryCache(key) == null) {
            mMemoryCache.put(key, drawable);
        }
    }

    /**
     * 从LruCache中去一张图片
     */
    public BitmapDrawable getBitmapFromMemoryCache(String key) {
        return mMemoryCache.get(key);
    }

    /**
     * 异步下载图片
     */
    class BitmapWorkerTask extends AsyncTask<String, Void, BitmapDrawable> {

        String imageUrl;

        @Override
        protected BitmapDrawable doInBackground(String... params) {
            String imageUrl = params[0];
            // 在后台开始下载图片
            Bitmap bitmap = getImageViewInputStream(imageUrl);
            BitmapDrawable drawable = new BitmapDrawable(getContext().getResources(),bitmap); 
            addBitmapToMemoryCache(imageUrl, drawable);
            return drawable;
        }

        @Override
        protected void onPostExecute(BitmapDrawable drawable) {
            ImageView imageView = (ImageView) mRecyclerView.findViewWithTag(imageUrl);
            if (imageView != null && drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /**
     * 建立http请求，获取bitmap
     */
    public Bitmap getImageViewInputStream(String string) {
        InputStream inputStream = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(string);
            if (url != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                int responseCode = httpURLConnection.getResponseCode();
                Log.d("*****", "ssss" + responseCode);
                if (responseCode == httpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
