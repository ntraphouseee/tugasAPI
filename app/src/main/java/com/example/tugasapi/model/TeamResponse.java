package com.example.tugasapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<Team> teamAdapters;

    public List<Team> getTeams() {
        return teamAdapters;
    }
}