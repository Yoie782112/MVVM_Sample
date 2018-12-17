package com.yoie.com.mvptest.model;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Serializable {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("family")
    @Expose
    private String family;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("variants")
    @Expose
    private List<String> variants = null;
    @SerializedName("subsets")
    @Expose
    private List<String> subsets = null;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @SerializedName("files")
    @Expose
    private Files files;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public List<String> getSubsets() {
        return subsets;
    }

    public void setSubsets(List<String> subsets) {
        this.subsets = subsets;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

}
