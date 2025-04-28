package com.example.tugasapi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasapi.adapter.teamAdapter;
import com.example.tugasapi.api.ApiClient;
import com.example.tugasapi.api.Retrofit;
import com.example.tugasapi.model.Team;
import com.example.tugasapi.model.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private teamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getTeams();
    }

    private void getTeams() {
        ApiClient apiClient = Retrofit.getRetrofitInstance().create(ApiClient.class);
        Call<TeamResponse> call = apiClient.getAllTeams("English Premier League");

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    adapter = new teamAdapter(MainActivity.this, teams);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("MainActivity", "Error: " + t.getMessage());
            }
        });
    }
    }
