package com.example.apicallforpost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/posts")
    Call<ResponseModel> getPost();
}
