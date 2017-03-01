package com.example.hecaiyang.retrofit.internet;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hecaiyang on 17/2/27.
 */

public interface BaiduService {
    @GET("/")          //请求类型
    Call<String> getBaidu();

}
