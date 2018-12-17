package com.yoie.com.mvptest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.yoie.com.mvptest.model.Font;
import com.yoie.com.mvptest.model.Item;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class ItemFontViewModel extends BaseObservable {
    private Item font;
    private Context context;

    public ItemFontViewModel(Item font, Context context) {
        this.font = font;
        this.context = context;
    }
    public String getKind() {
        return font.getKind();
    }
    public Item getFont() {
        return font;
    }


    public void setFont(Item font) {
        this.font = font;
        notifyChange();
    }

}
