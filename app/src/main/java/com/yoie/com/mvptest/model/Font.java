package com.yoie.com.mvptest.model;

import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Font implements Serializable {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = null;
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
