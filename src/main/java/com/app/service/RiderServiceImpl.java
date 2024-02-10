package com.app.service;

import com.app.custom_exception.MotoGPException;
import com.app.enities.Rider;
import com.app.repository.RiderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiderServiceImpl implements RiderService {

    @Autowired
    RiderRepo riderRepo;

    @Override
    public Rider getRiderDetails(String id) {
        return riderRepo.findById(id)
                .orElseThrow(() -> new MotoGPException("Rider Not Found"));
    }

    @Override
    public Rider AddRider(Rider newRider) {
        return riderRepo.save(newRider);
    }

    @Override
    public List<Rider> getAllRiders() {
        return riderRepo.findAll();
    }

    @Override
    public String deleteARider(String id) {
        try {
            riderRepo.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            throw new MotoGPException(e.getMessage());
        }
    }
}
