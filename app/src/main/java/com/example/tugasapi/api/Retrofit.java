package com.example.tugasapi.api;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    private static retrofit2.Retrofit retrofit;

    public static retrofit2.Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
