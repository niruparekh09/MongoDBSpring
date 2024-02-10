package com.app.service;

import com.app.custom_exception.MotoGPException;
import com.app.enities.Team;
import com.app.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServieImpl implements TeamService {

    @Autowired
    TeamRepo teamRepo;

    @Override
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @Override
    public Team addTeam(Team newTeam) {
        return teamRepo.save(newTeam);
    }

    @Override
    public List<Team> addTeams(List<Team> teamList) {
        return teamRepo.saveAll(teamList);
    }

    @Override
    public String deleteTeam(String id) {
        try {
            teamRepo.deleteById(id);
            return "Team Deleted";
        } catch (Exception e) {
            throw new MotoGPException(e.getMessage());
        }
    }


}
