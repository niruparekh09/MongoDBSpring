package com.app.controller;

import com.app.dto.APIResponse;
import com.app.enities.Rider;
import com.app.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    RiderService riderService;

    @PostMapping("/add")
    ResponseEntity<?> addRider(@RequestBody @Valid Rider newRider) {
        try {
            Rider newRiderInfo = riderService.AddRider(newRider);
            System.out.println("ID after saving: " + newRiderInfo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(newRiderInfo.toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }

    @GetMapping("/list")
    ResponseEntity<?> riderLists() {
        try {
            List<Rider> riderList = riderService.getAllRiders();
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse(riderList.toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRider(@PathVariable String id) {
        try {
            Rider riderInfo = riderService.getRiderDetails(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(riderInfo.toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(e.getMessage()));
        }
    }
}
