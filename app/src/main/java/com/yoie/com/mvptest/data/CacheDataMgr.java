package com.yoie.com.mvptest.data;

import android.content.Context;
import android.preference.PreferenceManager;

import com.yoie.com.mvptest.model.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CacheDataMgr {
    private static CacheDataMgr instance;
    private Context mContext;

    private CacheDataMgr(Context context){
        this.mContext = context;
    }

    public static CacheDataMgr getInstance(Context context){
        if(instance == null){
            synchronized(CacheDataMgr.class){
                if(instance == null){
                    instance = new CacheDataMgr(context);
                }
            }
        }
        return instance;
    }

    public static CacheDataMgr getInstance(){
        return instance;
    }




}
