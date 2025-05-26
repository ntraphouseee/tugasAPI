package com.example.tugasapi.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.tugasapi.model.TeamResponse;

public interface ApiService {
    @GET("api/v1/json/3/search_all_teams.php?s=Soccer")
    Call<TeamResponse> getTeams(
            @Query("c") String country // Parameter dinamis untuk negara
    );
}