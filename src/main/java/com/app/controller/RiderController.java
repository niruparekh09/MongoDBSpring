package com.app.controller;

import com.app.dto.APIResponse;
import com.app.enities.Rider;
import com.app.enities.Team;
import com.app.repository.TeamRepo;
import com.app.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rider")
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600) //React Vite
public class RiderController {

    @Autowired
    RiderService riderService;

    @Autowired
    TeamRepo teamRepo;

    @PostMapping("/add")
    ResponseEntity<?> addRider(@RequestBody @Valid Rider newRider) {
        /*I am basically removing the need of user to add any ID from frontend, rather I am taking the team name
         and fetching the ID by myself and replacing old Team reference inside newRider to new Team reference which
         also has ID added to it.*/
        try {
            Team team = newRider.getTeamName();
            newRider.setTeamName(teamRepo.findTeamByName(team.getName()));
            Rider newRiderInfo = riderService.AddRider(newRider);
            return ResponseEntity.status(HttpStatus.CREATED).body(newRiderInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }

    @GetMapping("/list")
    ResponseEntity<?> riderLists() {
        try {
            List<Rider> riderList = riderService.getAllRiders();
            return ResponseEntity.status(HttpStatus.OK).body(riderList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRider(@PathVariable String id) {
        try {
            Rider riderInfo = riderService.getRiderDetails(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(riderInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteRider(@PathVariable String id) {
        try {
            String deletedRider = riderService.deleteARider(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(deletedRider);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }
}
