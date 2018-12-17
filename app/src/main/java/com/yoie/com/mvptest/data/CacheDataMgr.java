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
        // 這裡面跑很了多code，建立物件需要花費很多資源
    }

    // 多執行緒時，當物件需要被建立時才使用synchronized保證Singleton一定是單一的 ，增加程式校能
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
