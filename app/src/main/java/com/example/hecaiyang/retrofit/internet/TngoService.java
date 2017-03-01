package com.example.hecaiyang.retrofit.internet;

import com.example.hecaiyang.retrofit.bean.Tngou;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hecaiyang on 17/2/27.
 */

public interface TngoService {
    @POST("/api/{category}/list")
//    Call<Tngou> getList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);
//   post上传数据要用属性
    @FormUrlEncoded
    Call<Tngou> getList(@Path("category") String category, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);
}
