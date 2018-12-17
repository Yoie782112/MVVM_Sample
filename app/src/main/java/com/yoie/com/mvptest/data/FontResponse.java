package com.yoie.com.mvptest.data;

import com.google.gson.annotations.SerializedName;
import com.yoie.com.mvptest.model.Font;

import java.util.List;

public class FontResponse {
    @SerializedName("results")
    private List<Font> fontList;

    public List<Font> getFontList() {
        return fontList;
    }
}
