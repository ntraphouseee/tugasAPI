package com.example.tugasapi.api;

import com.example.tugasapi.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getAllTeams(@Query("l") String league);
}