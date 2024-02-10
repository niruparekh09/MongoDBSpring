package com.app.service;

import com.app.enities.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    Team addTeam(Team newTeam);

    List<Team> addTeams(List<Team> teamList);

    String deleteTeam(String id);
}
