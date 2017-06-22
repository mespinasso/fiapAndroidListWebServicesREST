package com.example.logonrm.fiapandroidlistrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.logonrm.fiapandroidlistrest.adapter.AndroidAdapter;
import com.example.logonrm.fiapandroidlistrest.api.APIUtils;
import com.example.logonrm.fiapandroidlistrest.api.IAndroidAPI;
import com.example.logonrm.fiapandroidlistrest.model.Android;
import com.example.logonrm.fiapandroidlistrest.model.ResponseAndroid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAdapter androidAdapter;
    private IAndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        androidAdapter = new AndroidAdapter(new ArrayList<Android>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);

        /*RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);*/

        carregaDados();
    }

    private void carregaDados() {
        androidAPI = APIUtils.getAndroidAPIVersion();

        androidAPI.getVersions().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if(response.isSuccessful()) {
                    androidAdapter.update(response.body().getAndroidList());
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {

            }
        });
    }
}
