package com.pam.newsprojet.retrefit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    static Retrofit retrofit = null;
    public static String Base_URL = "http://soltana.ma/wp-json/wp/v2/";


    public static UserService getInterface() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setLenient()
                .disableHtmlEscaping()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(UserService.class);
    }

}
