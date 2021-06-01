package com.example.thithuchanh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl("https://60ab1b335a4de40017cc9577.mockapi.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService.class);

    @GET("user")
    Call<List<User>> findAll();

    @POST("user")
    Call<User> addUser(@Body User user);

    @DELETE("user/{id}")
    Call<User> deleteUser(@Path("id") String id);

    @PUT("user/{id}")
    Call<User> updateUser(@Path("id") String id, @Body User user);
}
