package com.found101.unnati.APIs;

import com.found101.unnati.Models.Users;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("users")
    Call<Users> users();

    @GET("posts")
    Call<Users> pitch();
}
