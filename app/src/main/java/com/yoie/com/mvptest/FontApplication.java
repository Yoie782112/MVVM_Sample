package com.yoie.com.mvptest;

import android.content.Context;

import com.yoie.com.mvptest.data.FontFactory;
import com.yoie.com.mvptest.data.FontService;
import android.support.multidex.MultiDexApplication;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class FontApplication extends MultiDexApplication {
    private FontService fontService;
    private Scheduler scheduler;

    private static FontApplication get(Context context) {
        return (FontApplication) context.getApplicationContext();
    }

    public static FontApplication create(Context context) {
        return FontApplication.get(context);
    }

    public FontService getFontService() {
        if (fontService == null) {
            fontService = FontFactory.create();
        }

        return fontService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setFontService(FontService fontService) {
        this.fontService = fontService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
