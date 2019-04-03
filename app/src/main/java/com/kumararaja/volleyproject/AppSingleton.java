package com.kumararaja.volleyproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AppSingleton {

    private static AppSingleton mAppsingletonInstance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context mcontext;

    private AppSingleton(Context context){
        mcontext=context;
        requestQueue=getRequestQueue();

        imageLoader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {

            private final LruCache<String,Bitmap> cache=new LruCache<String, Bitmap>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }

    public static synchronized AppSingleton getInstance(Context context){
        if (mAppsingletonInstance==null){
            mAppsingletonInstance=new AppSingleton(context);
        }
        return mAppsingletonInstance;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mcontext.getApplicationContext());

        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag){
        request.setTag(tag);
        getRequestQueue().add(request);

    }

    public ImageLoader imageLoader(){
        return imageLoader;
    }

    public void cancelPendingRequest(Object tag){
        if (requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }
}
