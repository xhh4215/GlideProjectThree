package com.example.xhh.glideprojectthree.model;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by xhh on 2017/12/19.
 */

public class MyGlideModule implements GlideModule {
    //    更改Glide配置
    public static final int DISK_CACHE_SIZE = 500 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        /**
         * setMemoryCache()
         用于配置Glide的内存缓存策略，默认配置是LruResourceCache。

         setBitmapPool()
         用于配置Glide的Bitmap缓存池，默认配置是LruBitmapPool。

         setDiskCache()
         用于配置Glide的硬盘缓存策略，默认配置是InternalCacheDiskCacheFactory。

         setDiskCacheService()
         用于配置Glide读取缓存中图片的异步执行器，默认配置是FifoPriorityThreadPoolExecutor，也就是先入先出原则。

         setResizeService()
         用于配置Glide读取非缓存中图片的异步执行器，默认配置也是FifoPriorityThreadPoolExecutor。

         setDecodeFormat()
         用于配置Glide加载图片的解码模式，默认配置是RGB_565。
         */
//        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context)); 默认的大小 250M
//        修改Glide的默认的缓存的位置为sd卡
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, DISK_CACHE_SIZE));
//        修改默认的图片的加载的格式
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    //  配置Glide组件
    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
