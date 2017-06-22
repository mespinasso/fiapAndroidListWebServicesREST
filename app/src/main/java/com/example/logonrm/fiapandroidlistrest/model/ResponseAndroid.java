package com.example.logonrm.fiapandroidlistrest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAndroid {

    @SerializedName("android")
    private List<Android> androidList;

    public List<Android> getAndroidList() {
        return androidList;
    }

    public void setAndroidList(List<Android> androidList) {
        this.androidList = androidList;
    }
}
