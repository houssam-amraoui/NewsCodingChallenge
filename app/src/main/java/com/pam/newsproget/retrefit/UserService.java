package com.pam.newsproget.retrefit;


import com.pam.newsproget.model.PostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {


    @GET("posts")
    Call<List<PostItem>> getposts(@Query("page")int page);
}
