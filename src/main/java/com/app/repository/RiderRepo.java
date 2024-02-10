package com.app.repository;

import com.app.enities.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiderRepo extends MongoRepository<Rider,String> {
}
