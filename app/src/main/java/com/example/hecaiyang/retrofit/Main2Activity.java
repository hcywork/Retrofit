package com.example.hecaiyang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hecaiyang.retrofit.bean.Cook;
import com.example.hecaiyang.retrofit.bean.Tngou;
import com.example.hecaiyang.retrofit.internet.TngoService;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements Callback<Tngou> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.tngou.net")
                .build();
        TngoService tngoService = retrofit.create(TngoService.class);
        Call<Tngou> call = tngoService.getList("cook", 0, 1, 20);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<Cook> list = response.body().getList();
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {
        t.printStackTrace();
    }
}
