package com.example.logonrm.fiapandroidlistrest.api;

public class APIUtils {

    public static final String BASE_URL = "http://www.mocky.io";

    public static IAndroidAPI getAndroidAPIVersion() {
        return RetrofitClient.getClient(BASE_URL).create(IAndroidAPI.class);
    }
}
