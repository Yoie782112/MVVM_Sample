package com.yoie.com.mvptest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Files implements Serializable {

    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("italic")
    @Expose
    private String italic;

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getItalic() {
        return italic;
    }

    public void setItalic(String italic) {
        this.italic = italic;
    }

}
