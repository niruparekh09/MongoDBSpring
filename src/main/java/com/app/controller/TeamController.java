package com.app.controller;

import com.app.dto.APIResponse;
import com.app.enities.Team;
import com.app.repository.TeamRepo;
import com.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepo teamRepo;

    @GetMapping("/{name}")
    ResponseEntity<?> getATeam(@PathVariable String name) {
        Team team = teamRepo.findTeamByName(name);
        return ResponseEntity.status(HttpStatus.FOUND).body(team);
    }

    @PostMapping("/add/oneTeam")
    ResponseEntity<?> addATeam(@RequestBody @Valid Team newTeam) {
        try {
            Team addedTeam = teamService.addTeam(newTeam);
            return ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(addedTeam.toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllTeam() {
        try {
            List<Team> teamList = teamService.getAllTeams();
            return ResponseEntity.status(HttpStatus.FOUND).body(teamList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(e.getMessage()));
        }
    }

    @PostMapping("/add/manyTeams")
    ResponseEntity<?> addTeams(@RequestBody @Valid List<Team> teamList) {
        try {
            List<Team> addedTeamList = teamService.addTeams(teamList);
            return ResponseEntity.status(HttpStatus.FOUND).body(addedTeamList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }
}
