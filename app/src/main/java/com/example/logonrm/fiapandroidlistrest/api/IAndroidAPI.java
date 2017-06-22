package com.example.logonrm.fiapandroidlistrest.api;

import com.example.logonrm.fiapandroidlistrest.model.ResponseAndroid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAndroidAPI {

    @GET("/v2/58af1fb21000001e1cc94547")
    Call<ResponseAndroid> getVersions();

}