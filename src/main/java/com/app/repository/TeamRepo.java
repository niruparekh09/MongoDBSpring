package com.app.repository;

import com.app.enities.Team;
import org.springframework.data.mongodb.SpringDataMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepo extends MongoRepository<Team,String> {
    public Team findTeamByName(String teamName);
}
