package com.example.hecaiyang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hecaiyang.retrofit.internet.BaiduService;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com")
                .addConverterFactory(
                        new Converter.Factory() {
                            @Override
                            public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                                return new Converter<ResponseBody, String>() {
                                    @Override
                                    public String convert(ResponseBody value) throws IOException {
                                        return value.string();
                                    }
                                };
                            }
                        }
                ).build();



        text = (TextView) findViewById(R.id.main_text);



        BaiduService baiduService = retrofit.create(BaiduService.class);
        Call call=baiduService.getBaidu();


        call.enqueue(this);
    }

    @Override
    public void onResponse(Call call, Response response) {
        text.setText(response.body().toString());
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
